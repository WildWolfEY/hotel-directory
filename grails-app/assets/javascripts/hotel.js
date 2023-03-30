class Country {
    id;
    name;
    capital;

    constructor(name, capital) {
        this.name = name;
        this.capital = capital;
    }
}
class Hotel {
    id;
    name;
    stars;
    website;
    countryId;

    constructor(name, stars, countryId, website) {
        this.name = name;
        this.stars = stars;
        this.countryId = countryId;
        this.website = website;
    }
}

var hotel = new Hotel("", "", "", "", "");

$(document).ready(function () {
    $("tr").click(trClick);
    $("#selectedCountry").on("change", function() {
        window.location.href = "hotel?selectedCountry="+this.value;
    });
});
function selectCountry(){
    alert(this.value)
}
function trClick() {
    var row = $(this);
    hotel.id = $("td", row).eq(0).text();
    hotel.name = $("td", row).eq(1).text();
    hotel.stars = $("td", row).eq(2).text();
    hotel.website = $("td", row).eq(3).text();
    if (!row.hasClass("bg-light")) {
        $("tr").removeClass("bg-light");
        row.addClass("bg-light");
        $("#add").addClass("d-none");
        $("#edit").removeClass("d-none");
        $("input[name='id']").val(hotel.id);
        $("#new_name").val(hotel.name);
        $("#new_stars").val(hotel.stars);
        $("#new_website").val(hotel.website);
        $("#new_country").val(hotel.countryId);

    } else {
        $(this).removeClass("bg-light");
        $("#add").removeClass("d-none");
        $("#edit").addClass("d-none");
    }
}