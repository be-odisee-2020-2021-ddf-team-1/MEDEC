let besteldToestel;

function create() {
    let naam = $("#naam").val().toString();
    let aankoopdatum = $("#aankoopdatum").val();
    if (isNaN(aankoopdatum)) aankoopdatum = new Date(aankoopdatum).getTime();
    let prijs = parseFloat($("#prijs").val());
    console.log(aankoopdatum);
    $.post('http://localhost:8080/besteldtoestel/createBesteldToestel', {
        aankoopdatumMillis: aankoopdatum,
        naam: naam,
        prijs: prijs
    }).done(function () {
        window.location.href = "http://localhost:8080/besteldtoestel/OverviewBesteldeToestellen.html";
        console.log('SUCCESS');
    });
}