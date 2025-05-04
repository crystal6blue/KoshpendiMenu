const login = document.querySelector('.login');
const loginBtn = document.querySelector('.login button');
const loginInput = document.querySelector('.login input');
let countdownTime = 60;

loginBtn.addEventListener('click', () => {
  if (loginInput.value.length === 0) {
    alert("Please fill in the input");
    return;
  }

  const input = loginInput.value;

  // Update the inner HTML
  login.innerHTML = `
    <div class="container">
      <div class="sms-code-container">
        <h2>SMS коды</h2>
        <p>${input} ${input.includes('@') ? 'почтасына' : 'номеріне'} растау коды бар SMS жіберілді</p>
        <div class="otp-input">
          <input type="text" maxlength="1" />
          <input type="text" maxlength="1" />
          <input type="text" maxlength="1" />
          <input type="text" maxlength="1" />
        </div>
        <a href="../addtocardv2-main/index.html" class="next-button" id="nextButton">Ары қарай</a>
        <p id="timer">Қайта жіберу 01:00</p>
      </div>
    </div>
  `;

  // Wait for the DOM to be updated
  const timerElement = document.getElementById("timer");

  function updateTimer() {
    if (countdownTime > 0) {
      countdownTime--;
      const minutes = Math.floor(countdownTime / 60);
      const seconds = countdownTime % 60;
      timerElement.textContent = `Қайта жіберу ${formatTime(minutes)}:${formatTime(seconds)}`;
    } else {
      timerElement.textContent = "Қайта жіберу мүмкін";
      clearInterval(timerInterval);
    }
  }

  const timerInterval = setInterval(updateTimer, 1000);

  // Handle OTP input auto-focus
  const otpInputs = document.querySelectorAll(".otp-input input");
  otpInputs.forEach((input, index) => {
    input.addEventListener("input", () => {
      if (input.value.length === 1 && index < otpInputs.length - 1) {
        otpInputs[index + 1].focus();
      }
    });
  });

  // Handle "Ары қарай" button
  document.getElementById("nextButton").addEventListener("click", () => {
    alert("SMS код подтвержден!");
  });
});

function formatTime(time) {
  return time < 10 ? "0" + time : time;
}
