function getDeptStations() {
$("#txDestination").autocomplete({
  source: function (request, response) {
    var term = request.term;
    var Query = "";
    if (lang === "en")
      Query = "City_Name_EN";
    else if (lang === "fr")
      Query = "City_Name_FR";
    if (lang === "de")
      Query = "City_Name_DE";
    if (lang === "ar")
      Query = "City_Name_AR";
    var requestUri = "/_api/lists/getbytitle('Stations')/items?$select=City_Code," + Query + "&$filter=startswith(" + Query + ",'" + term + "')";
    $.ajax({
      url: requestUri,
      type: "GET",
      async: false,
      headers: {
        "ACCEPT": "application/json;odata=verbose"
      }
    }).done(function (data) {
      if (data.d.results) {
        response($.map(eval(data.d.results), function (item) {
          return {
            label: item[Query] + " (" + item.City_Code + ")",
            value: item[Query],
            id: item[Query]
          }
        }));
      }
      else {

      }
    });
  },
  response: function (event, ui) {
    if (!ui.content.length) {
      var noResult = { value: "", label: "No cities matching your request" };
      ui.content.push(noResult);
    }
  },
  select: function (event, ui) {
    $("#txDestination").val(ui.item.label);
            cityID = ui.item.id;
  },
  minLength: 1
});
 }