

const login = document.querySelector('.login');
const loginBtn = document.querySelector('.login button');
const loginInput = document.querySelector('.login input');
let countdownTime = 60;

loginBtn.addEventListener('click', async (e) => {
  e.preventDefault();

  const input = loginInput.value.trim();
  if (input.length === 0) {
    alert("Please fill in the input");
    return;
  }

  // 1. Отправляем GET-запрос для получения кода
  try {
    const response = await fetch(`http://localhost:8086/message?account=${encodeURIComponent(input)}`, {
      method: "POST"
    });
  
    if (!response.ok) throw new Error("Failed to send code");
  } catch (err) {
    alert("Ошибка при отправке кода: " + err.message);
    return;
  }
  
  

  // 2. Показываем поле ввода кода
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
          <input type="text" maxlength="1" />
          <input type="text" maxlength="1" />
        </div>
        <button id="verifyCode">Ары қарай</button>
        <p id="timer">Қайта жіберу 01:00</p>
      </div>
    </div>
  `;

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

  const otpInputs = document.querySelectorAll(".otp-input input");
  otpInputs.forEach((input, index) => {
    input.addEventListener("input", () => {
      if (input.value.length === 1 && index < otpInputs.length - 1) {
        otpInputs[index + 1].focus();
      }
    });
  });

  document.getElementById("verifyCode").addEventListener("click", async () => {
    const code = Array.from(otpInputs).map(input => input.value).join('');
    if (code.length !== 6) {
      alert("Код должен быть из 6 цифр");
      return;
    }

    try {
      const res = await fetch("http://localhost:8086/message/code/check", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ account: input, code })
      });

      const result = await res.json();

      if (res.ok) {
        alert("Код подтвержден!");
        window.location.href = "../addtocardv2-main/index.html";
      } else {
        alert("Неверный код: " + (result.message || "Ошибка"));
      }
    } catch (err) {
      alert("Ошибка при проверке кода: " + err.message);
    }
  });
});

function formatTime(time) {
  return time < 10 ? "0" + time : time;
}
