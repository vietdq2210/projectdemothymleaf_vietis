function openModal(modal) {
    const myModal = new bootstrap.Modal(document.getElementById(modal));
    myModal.show();
}

function showToast(id) {
    const toast = new bootstrap.Toast(document.getElementById(id));
    toast.show();
}

function getAntennaById(id) {
    document.getElementById("btn-show-list-booked" + id).href = "/antenna/update?id=" + id;
}