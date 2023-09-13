//window.onload = showMealPlan();
//const meals = document.querySelector('#meals');
//const axios = require('axios');
const meal1 = document.getElementById('meal1');
const meal2 = document.getElementById('meal2');
const meal3 = document.getElementById('meal3');
const meal4 = document.getElementById('meal4');
const meal5 = document.getElementById('meal5');
const meal6 = document.getElementById('meal6');
const meal7 = document.getElementById('meal7');

//window.onload = async function(evt) {
//  evt.preventDefault();
//  console.log("Getting Meal Plan Data...");
//  axios.get("arn:aws:execute-api:us-west-2:402163800520:vkcm4vwq7e/*/GET/mealplan")
//    .then(response) {
//      const meals = document.getElementById("meals");
//      for (const meal of response.data) {
//        const liElement = document.createElement('li');
//        liElement.textContent = meal.mealName;
//        meals.appendChild(liElement);
//      }
//      console.log(response.data);
//      window.location.reload();
//    }
//}

meal1.addEventListener("click", showImage1);
meal2.addEventListener("click", showImage2);
meal3.addEventListener("click", showImage3);
meal4.addEventListener("click", showImage4);
meal5.addEventListener("click", showImage5);
meal6.addEventListener("click", showImage6);
meal7.addEventListener("click", showImage7);

function showImage1(evt) {
    const imageURL = 'https://dinner-decider.s3.us-west-2.amazonaws.com/meal-images/Steak+and+Hollandaise.jpg';
    const image = document.createElement('img');
    image.src = imageUrl;
    document.body.appendChild(image);
}

function showImage2(evt) {
    const imageURL = 'https://dinner-decider.s3.us-west-2.amazonaws.com/meal-images/Grilled-Cheese.jpg';
    const image = document.createElement('img');
    image.src = imageUrl;
    document.body.appendChild(image);
}

function showImage3(evt) {
    const imageURL = 'https://dinner-decider.s3.us-west-2.amazonaws.com/meal-images/Greek-Chicken-Tzatziki-Bowls.jpg';
    const image = document.createElement('img');
    image.src = imageUrl;
    document.body.appendChild(image);
}

function showImage4(evt) {
    const imageURL = 'https://dinner-decider.s3.us-west-2.amazonaws.com/meal-images/Pork-Chops-with-Creamy-Mustard-Sauce.jpg';
    const image = document.createElement('img');
    image.src = imageUrl;
    document.body.appendChild(image);
}

function showImage5(evt) {
    const imageURL = 'https://dinner-decider.s3.us-west-2.amazonaws.com/meal-images/Walking-Tacos.jpg';
    const image = document.createElement('img');
    image.src = imageUrl;
    document.body.appendChild(image);
}

function showImage6(evt) {
    const imageURL = 'https://dinner-decider.s3.us-west-2.amazonaws.com/meal-images/Gyros.jpg';
    const image = document.createElement('img');
    image.src = imageUrl;
    document.body.appendChild(image);
}

function showImage7(evt) {
    const imageURL = 'https://dinner-decider.s3.us-west-2.amazonaws.com/meal-images/Vodka-Pasta.jpg';
    const image = document.createElement('img');
    image.src = imageUrl;
    document.body.appendChild(image);
}