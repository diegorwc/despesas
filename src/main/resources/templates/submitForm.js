$("#submitButton").click(function() {
       var formData = $("#cadastroForm").serializeArray();
       var jsonData = {};
       $(formData).each(function(i, field) {
          jsonData[field.name] = field.value;
       });

       $.ajax({
          url: "/novaDespesa",
          type: "POST",
          contentType: "application/json",
          data: JSON.stringify(jsonData),
          success: function(response) {
             console.log("ok");
          }
       });
 });