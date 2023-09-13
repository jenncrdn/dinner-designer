//window.onload = showOptions();
const numOFMealsForm = document.querySelector("#number-of-meals-form");
const buttons = document.querySelectorAll("button");
//const finalize = document.querySelector("#finalize");
//const axios = require('axios');
document.getElementById('finalize').addEventListener('click', finalizeMealPlan);

//window.onload = function(evt) {
//evt.preventDefault();
//console.log("Getting Meal Options Data...");
//axios.get("https://vkcm4vwq7e.execute-api.us-west-2.amazonaws.com/mealplan/options")
//    .then(function (response) {
//      const meals = document.getElementById("meals");
//      for (const meal of response.data) {
//        const liElement = document.createElement('li');
//        liElement.textContent = meal.mealName;
//        meals.appendChild(liElement);
//      }
//      console.log(response);
//      window.location.reload();
//    });
//}

numOFMealsForm.onsubmit = async function(evt) {
  evt.preventDefault();
  console.log("Getting Meal Options...");
  let numOfMeals = document.querySelector("#numOfMeals").value;

  const mealOptions = [
    { id: 1, name: "Smothered Chicken Burritos" },
    { id: 2, name: "Lasagna" },
    { id: 3, name: "Vegetable Stir Fry" },
    { id: 4, name: "Pizza" },
    { id: 5, name: "Stromboli" },
    { id: 6, name: "Quiche" },
    { id: 7, name: "Ham and Cheese Sliders" },
    { id: 8, name: "Fish and Chips" },
  ];

  let list = document.querySelector("#meal-list");

  for (let i = 0; i <= numOfMeals; i++) {
    let meal = mealOptions[i];
    let li = document.createElement("li");
    li.innerHTML = meal.name;
    list.appendChild(li);

    let button = document.getElementById("meals[" + i + "]");
    li.appendChild(button)
  }
};




//axios({
//    method: 'post',
//    url: 'http://arn:aws:execute-api:us-west-2:402163800520:vkcm4vwq7e/*/POST/mealplan/create',
//    data: {
//        numOfMeals: 'numOfMeals'
//    }
//})
//  .then((response) => {
//    const meals = document.getElementById("meals");
//      for (const meal of response.data) {
//        const liElement = document.createElement('li');
//        liElement.textContent = meal.mealName;
//        meals.appendChild(liElement);
//      }
//    console.log(response);
//    window.location.reload();
//  })



function finalizeMealPlan() {
axios.post("arn:aws:execute-api:us-west-2:402163800520:vkcm4vwq7e/*/POST/mealplan/finialize")
  .then((res) => {
    console.log(res);
    window.location.reload();
  })
}

//
//axios.put("arn:aws:execute-api:us-west-2:402163800520:vkcm4vwq7e/*/PUT/mealplan/{mealId}/reject", mealId)
//  .then(response)
//  console.log(response);
