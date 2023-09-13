const axios = require('axios');

axios.get("arn:aws:execute-api:us-west-2:402163800520:vkcm4vwq7e/*/GET/meals")
  .then(function (response) {
    console.log(response);
  })

axios.post("arn:aws:execute-api:us-west-2:402163800520:vkcm4vwq7e/*/POST/mealplan/request", mealId, {
  }).then((res) => {
    console.log(res);
    window.location.reload();
  })

