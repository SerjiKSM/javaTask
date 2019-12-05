
$('.country').change(function() {
    var val = $(".country option:selected").text();

    if (val == "USA") {
        $(".usa_states").show();
        $(".canada_provinces_cities").hide();
    }

    if (val == "CANADA") {
        $(".usa_states").hide();
        $(".canada_provinces_cities").show();
    }
});
