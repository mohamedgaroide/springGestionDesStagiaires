
    // CONFIGURATION
    const API_URL = "http://localhost:8081/stagiaires";
    const tableBody = document.getElementById('tableBody');
    const form = document.getElementById('stagiaireForm');
    let id=1;

    // auto scroll to top after each CRUD operation
    function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth' 
    });
}
    // gets the data from the backend
    function loadStagiaires() {
        fetch(API_URL)
            .then(response => response.json())
            .then(data => {
                tableBody.innerHTML = "";
                data.forEach((stagiaire, i)=> addToTable(stagiaire, i+1));
            })
            .catch(err => console.error("Erreur de chargement:", err));
    }

    // retrieves stagiaire's infos + (i) ="index,the id shown to the user so it wont show the real id from the DB"
    function addToTable(stagiaire,i) {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td class="ps-4 align-middle">${i}</td>
            <td class="align-middle text-uppercase fw-semibold">${stagiaire.nom} <span class="text-capitalize fw-normal">${stagiaire.prenom}</span></td>
            <td class="text-center">
                <button class="btn btn-outline-primary btn-sm" onclick="openUpdateModal(${i},${stagiaire.id}, '${stagiaire.nom}', '${stagiaire.prenom}')">
                    Modifier
                </button>
                <button class="btn btn-outline-danger btn-sm" onclick="deleteStagiaire(${i},${stagiaire.id})">
                    Supprimer
                </button>
            </td>
        `;
        tableBody.appendChild(row);
    }

    
    form.addEventListener('submit', function(e) {
        e.preventDefault();
        const newStagiaire = {
            nom: document.getElementById('nom').value,
            prenom: document.getElementById('prenom').value
        };

        fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(newStagiaire)
        })
        .then(response => {
            if(response.ok) return response.json();
            throw new Error("Erreur lors de l'ajout");
        })
        .then(savedStagiaire => {
            loadStagiaires();
            form.reset();
            const messageSection = document.getElementById('message');
            messageSection.innerHTML = `<div class="alert alert-success" >Le nouveau stagiaire a été ajouté avec succès.</div>`
            messageSection.classList.remove("hidden");
            setTimeout(() => messageSection.classList.add("hidden"), 3000);
            scrollToTop();
        })
        .catch(err => alert("Erreur: " + err));
    });

    window.deleteStagiaire = function(i,id) {
        if(!confirm("Voulez-vous vraiment supprimer ce stagiaire ?")) return;

        fetch(`${API_URL}/${id}`, { method: "DELETE" })
        .then(response => {
            if(response.ok) {
            loadStagiaires();
            const messageSection = document.getElementById('message');
            messageSection.innerHTML = `<div class="alert alert-danger" >Le stagiaire avec l'identifiant ${i} a été supprimé.</div>`
            messageSection.classList.remove("hidden");
            setTimeout(() => messageSection.classList.add("hidden"), 3000); 
            scrollToTop();           
            }
            else alert("Erreur lors de la suppression");
            
        })
        .catch(err => console.error(err));
    };

    loadStagiaires();
    let updateModal; // Will hold the Bootstrap Modal instance

    // 1. Open the popup and fill it with data
    window.openUpdateModal = function(displayIndex, databaseId, nom, prenom) {
        //store the displayIndex
        document.getElementById('updateForm').setAttribute('data-display-index', displayIndex);
        // Fill the hidden ID and the text inputs
        document.getElementById('modalId').value = databaseId;
        document.getElementById('modalNom').value = nom;
        document.getElementById('modalPrenom').value = prenom;

        // Initialize the modal if it hasn't been already, then show it
        if (!updateModal) {
            updateModal = new bootstrap.Modal(document.getElementById('updateModal'));
        }
        updateModal.show();
    };
    document.getElementById("updateForm").addEventListener("submit", function(e) {
        e.preventDefault(); // prevent page reload

        submitUpdate(); // call your function
    });

    window.submitUpdate = function() {
        //retrieve the displayIndex
        const displayIndex = document.getElementById('updateForm').getAttribute('data-display-index');
        // 1. Get the ID directly from the input
        const databaseId = document.getElementById('modalId').value;
        
        // 2. Create the body object
        const updatedData = {
            nom: document.getElementById('modalNom').value,
            prenom: document.getElementById('modalPrenom').value
        };

        // 3. Send the request
        fetch(`${API_URL}/${databaseId}`, { 
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(updatedData)
        })
        .then(response => {
            if (response.ok) {
                //fix a focus bug bootstrap
                if (document.activeElement) {
                document.activeElement.blur();
            }
                loadStagiaires();
                updateModal.hide();
                
                const messageSection = document.getElementById('message'); 
                messageSection.innerHTML = `<div class="alert alert-info">Le stagiaire avec l id numero ${displayIndex} été mis à jour avec succès.</div>`;
                messageSection.classList.remove("hidden");
                setTimeout(() => messageSection.classList.add("hidden"), 3000);
                scrollToTop();
            } else {
                alert("Erreur lors de la modification");
            }
        })
        .catch(err => console.error("Erreur:", err));
    };

