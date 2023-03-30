
class Country {
    id;
    name;
    capital;
    hotels;

    constructor(name, capital) {
        this.name = name;
        this.capital = capital;
    }
}

var country = new Country("", ""
    )
;
$(document).ready(function () {
    $("tr").click(function () {
        var row = $(this);
        country.id = $("td", row).eq(0).text();
        country.name = $("td", row).eq(1).text();
        country.capital = $("td", row).eq(2).text();
        $("input[name='id']").val(country.id);
        $("#new_name").val(country.name);
        $("#new_capital").val(country.capital);
        if (!row.hasClass("bg-light")) {
            $("tr").removeClass("bg-light");
            row.addClass("bg-light");
            $("#add").addClass("d-none");
            $("#edit").removeClass("d-none");
        } else {
            $(this).removeClass("bg-light");
            $("#add").removeClass("d-none");
            $("#edit").addClass("d-none");
        }
    });
})
;
