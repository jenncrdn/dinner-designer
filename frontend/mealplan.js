window.onload = showMealPlan();
const meals = document.querySelector('#meals');
const axios = require('axios');

window.onload = async function(evt) {
  evt.preventDefault();
  console.log("Getting Meal Plan Data...");
  axios.get("arn:aws:execute-api:us-west-2:402163800520:vkcm4vwq7e/*/GET/mealplan")
    .then(response) {
      const meals = document.getElementById("meals");
      for (const meal of response.data) {
        const liElement = document.createElement('li');
        liElement.textContent = meal.mealName;
        meals.appendChild(liElement);
      }
      console.log(response.data);
      window.location.reload();
    }
}
