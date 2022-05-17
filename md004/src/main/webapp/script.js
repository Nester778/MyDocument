const selectEl = document.getElementById('select');
const registrationImage = document.getElementById('planet-img');
const textToChange = document.getElementById('text-to-change');
const labels = document.querySelectorAll('label');
const options = document.querySelectorAll('option');
const button = document.querySelector('.form-submit-button');


selectEl.addEventListener('change', function() {


switch(true) {
    case this.value === 'mercury' : registrationImage.src = "./Assets/PassportMercu.png"; 
                        document.body.style.backgroundImage = "url(./Assets/BgMercu.png)"
    break;
    case this.value === 'venus' : registrationImage.src = "./Assets/PassportVenus.png"; 
                        document.body.style.backgroundImage = "url(./Assets/BgVenus.png)"
    break;
    case this.value === 'earth' : registrationImage.src = "./Assets/PassportEarth.png"; 
                        document.body.style.backgroundImage = "url(./Assets/BgEarth.png)"
    break;
    case this.value === 'mars' : registrationImage.src = "./Assets/PassportMars.png"; 
                        document.body.style.backgroundImage = "url(./Assets/BgMars.png)"
    break;
    case this.value === 'saturn' : registrationImage.src = "./Assets/PassportSaturn.png"; 
                        document.body.style.backgroundImage = "url(./Assets/BgSaturn.png)"
    break;
    case this.value === 'jupiter' : registrationImage.src = "./Assets/PassportJupiter.png"; 
                        document.body.style.backgroundImage = "url(./Assets/BgJupiter.png)"
    break;
    case this.value === 'uranus' : registrationImage.src = "./Assets/PassportUranus.png"; 
                        document.body.style.backgroundImage = "url(./Assets/BgUranus.png)"
    break;
    case this.value === 'neptune' : registrationImage.src = "./Assets/PassportNeptune.png"; 
                        document.body.style.backgroundImage = "url(./Assets/BgNeptune.png)"
    break;
}

})




document.querySelector('#submit').onclick = function(){
    
    globalThis.push(document.getElementsByName('name')[0].value)
    alert(globalThis[0])

    const phone = document.getElementsByName('phone')[0].value
    alert(phone)
}

