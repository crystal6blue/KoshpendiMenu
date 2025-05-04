const chatBody = document.querySelector(".chat-body");
const messageInput = document.querySelector(".message-input");
const sendMessage = document.querySelector("#send-message");
const fileInput = document.querySelector("#file-input");
const fileUploadWrapper = document.querySelector(".file-upload-wrapper");
const fileCancelButton = fileUploadWrapper.querySelector("#file-cancel");
const chatbotToggler = document.querySelector("#chatbot-toggler");
const closeChatbot = document.querySelector("#close-chatbot");


let faqContent = `📍 Ресторан "Шанырак" – Алматы
📌 Местоположение:
Адрес: ул. Толе би, 123, район Алмалинский, г. Алматы, Казахстан
Ориентир: рядом с ТРЦ "Dostyk Plaza"
Парковка: бесплатная, перед входом
Метро: станция "Абай", 7 минут пешком

🍽️ Меню (основные позиции):
🥩 Гриль и шашлыки:
Шашлык из баранины — 3 500 ₸
Шашлык из курицы — 2 800 ₸
Люля-кебаб — 3 200 ₸
Ассорти из мяса (на 2 персоны) — 8 500 ₸

🍚 Национальные блюда:
Плов ферганский — 2 900 ₸
Лагман — 2 700 ₸
Манты (6 шт.) — 2 400 ₸
Куырдак — 3 100 ₸

🥗 Закуски и салаты:
Салат "Ачучук" — 1 200 ₸
Свежие овощи с зеленью — 1 500 ₸
Салат "Оливье" — 1 600 ₸

🍰 Десерты:
Чак-чак — 1 100 ₸
Баурсаки с мёдом — 1 200 ₸
Торт "Медовик" — 1 500 ₸

☕ Напитки:
Чай зелёный/чёрный в чайнике — 1 000 ₸
Компот домашний — 800 ₸
Айран — 700 ₸
Минеральная вода — 500 ₸

🕒 Время работы:
Ежедневно: с 10:00 до 23:00
Доставка и самовывоз: с 11:00 до 22:30

🎉 Атмосфера и особенности:
Тёплый восточный интерьер с современными элементами
Живая музыка по пятницам и субботам
Летняя терраса (доступна с апреля по октябрь)
Детский уголок
Подходит для семейных ужинов, встреч с друзьями, дней рождения и деловых обедов

📞 Контакты:
Телефон: +7 (727) 123-45-67
WhatsApp: +7 701 123 45 67
Instagram: @shashlyk_plov_almaty
Сайт: www.shashlykplov.kz

📋 Дополнительно:
Бесплатный Wi-Fi
Возможность бронировать столы
Проведение банкетов до 50 человек
Принимаются карты и наличные

Часто задаваемые вопросы (FAQ)
❓ Есть ли у вас доставка?
✅ Да, доставка работает ежедневно с 11:00 до 22:30. Заказы принимаются по телефону, WhatsApp или через наш сайт. Доставка по городу — от 1 000 ₸, при заказе от 10 000 ₸ — бесплатно.
❓ Есть ли у вас халяльное мясо?
✅ Да, все наши мясные продукты имеют халяль-сертификаты. Мы сотрудничаем только с проверенными поставщиками.
❓ Можно ли забронировать столик?
✅ Да, бронирование осуществляется по телефону или через Instagram. Рекомендуем бронировать заранее, особенно на выходные.
❓ Есть ли блюда для вегетарианцев?
✅ Да, в меню есть овощные закуски, салаты, баурсаки, десерты, а также лагман без мяса (по запросу).
❓ Можно ли провести банкет?
✅ Да, у нас есть отдельный банкетный зал на 50 гостей. Предоставляем спецменю, украшения и музыкальное сопровождение.

📄 Сертификаты и гарантии качества
✅ Сертификаты Халяль — выданы Комитетом по стандарту «Халяль» Казахстана.
✅ Санитарно-гигиенические заключения — в соответствии с требованиями СЭС.
✅ Сертификаты происхождения продуктов — от фермерских хозяйств Алматы и Алматинской области.
✅ Все сотрудники кухни проходят ежеквартальный медосмотр и санитарную подготовку.

🛡️ Безопасность и гигиена
Все кухни оборудованы по стандартам HACCP
Ежедневная дезинфекция поверхностей и зон приготовления пищи
Контроль температуры хранения продуктов
Посудомоечные машины с термообработкой
Одноразовые перчатки и маски на кухне

⚠️ Аллергены
Уточните при заказе — некоторые блюда могут содержать:
Глютен (мука, соусы)
Орехи (десерты)
Молочные продукты
Яйца

🔍 По запросу официант предоставит таблицу аллергенов по каждому блюду.

📦 Качество и свежесть
Мясо — поставляется ежедневно, не используется заморозка
Овощи — только от местных фермеров, без нитратов
Без использования глутамата натрия и искусственных добавок`;


// API setup
const API_KEY = "AIzaSyCTZEVm8rroJvih7c9f0TtVElSoVvvj1Po";
const API_URL = `https://generativelanguage.googleapis.com/v1/models/gemini-1.5-pro:generateContent?key=${API_KEY}`;

// Initialize user message and file data
const userData = {
  message: null,
  file: {
    data: null,
    mime_type: null,
  },
};

// Store chat history
const chatHistory = [];
const initialInputHeight = messageInput.scrollHeight;

// Create message element with dynamic classes and return it
const createMessageElement = (content, ...classes) => {
  const div = document.createElement("div");
  div.classList.add("message", ...classes);
  div.innerHTML = content;
  return div;
};

// Generate bot response using API
const generateBotResponse = async (incomingMessageDiv) => {
  const messageElement = incomingMessageDiv.querySelector(".message-text");

  // Add user message to chat history
  chatHistory.push({
    role: "user",
    parts: [{ text: `${faqContent}\n\nБудь как онлайн-ассистент для этого ресторана.\n\n${userData.message}` }, ...(userData.file.data ? [{ inline_data: userData.file }] : [])],
  });


  // API request options
  const requestOptions = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      contents: chatHistory,
    }),
  };

  try {
    // Fetch bot response from API
    const response = await fetch(API_URL, requestOptions);
    const data = await response.json();
    if (!response.ok) throw new Error(data.error.message);

    // Extract and display bot's response text
    const apiResponseText = data.candidates[0].content.parts[0].text.replace(/\*\*(.*?)\*\*/g, "$1").trim();
    messageElement.innerText = apiResponseText;

    // Add bot response to chat history
    chatHistory.push({
      role: "model",
      parts: [{ text: apiResponseText }],
    });
  } catch (error) {
    // Handle error in API response
    console.log(error);
    messageElement.innerText = error.message;
    messageElement.style.color = "#ff0000";
  } finally {
    // Reset user's file data, removing thinking indicator and scroll chat to bottom
    userData.file = {};
    incomingMessageDiv.classList.remove("thinking");
    chatBody.scrollTo({ top: chatBody.scrollHeight, behavior: "smooth" });
  }
};

// Handle outgoing user messages
const handleOutgoingMessage = (e) => {
  e.preventDefault();
  userData.message = messageInput.value.trim();
  messageInput.value = "";
  messageInput.dispatchEvent(new Event("input"));
  fileUploadWrapper.classList.remove("file-uploaded");

  // Create and display user message
  const messageContent = `<div class="message-text"></div>
                          ${userData.file.data ? `<img src="data:${userData.file.mime_type};base64,${userData.file.data}" class="attachment" />` : ""}`;

  const outgoingMessageDiv = createMessageElement(messageContent, "user-message");
  outgoingMessageDiv.querySelector(".message-text").innerText = userData.message;
  chatBody.appendChild(outgoingMessageDiv);
  chatBody.scrollTo({ top: chatBody.scrollHeight, behavior: "smooth" });

  // Simulate bot response with thinking indicator after a delay
  setTimeout(() => {
    const messageContent = `<img class="bot-avatar" src="robotic.png" alt="Chatbot Logo" width="50" height="50">
          </img>
          <div class="message-text">
            <div class="thinking-indicator">
              <div class="dot"></div>
              <div class="dot"></div>
              <div class="dot"></div>
            </div>
          </div>`;

    const incomingMessageDiv = createMessageElement(messageContent, "bot-message", "thinking");
    chatBody.appendChild(incomingMessageDiv);
    chatBody.scrollTo({ top: chatBody.scrollHeight, behavior: "smooth" });
    generateBotResponse(incomingMessageDiv);
  }, 600);
};

// Adjust input field height dynamically
messageInput.addEventListener("input", () => {
  messageInput.style.height = `${initialInputHeight}px`;
  messageInput.style.height = `${messageInput.scrollHeight}px`;
  document.querySelector(".chat-form").style.borderRadius = messageInput.scrollHeight > initialInputHeight ? "15px" : "32px";
});

// Handle Enter key press for sending messages
messageInput.addEventListener("keydown", (e) => {
  const userMessage = e.target.value.trim();
  if (e.key === "Enter" && !e.shiftKey && userMessage && window.innerWidth > 768) {
    handleOutgoingMessage(e);
  }
});

// Handle file input change and preview the selected file
fileInput.addEventListener("change", () => {
  const file = fileInput.files[0];
  if (!file) return;

  const reader = new FileReader();
  reader.onload = (e) => {
    fileInput.value = "";
    fileUploadWrapper.querySelector("img").src = e.target.result;
    fileUploadWrapper.classList.add("file-uploaded");
    const base64String = e.target.result.split(",")[1];

    // Store file data in userData
    userData.file = {
      data: base64String,
      mime_type: file.type,
    };
  };

  reader.readAsDataURL(file);
});

// Cancel file upload
fileCancelButton.addEventListener("click", () => {
  userData.file = {};
  fileUploadWrapper.classList.remove("file-uploaded");
});

// Initialize emoji picker and handle emoji selection
const picker = new EmojiMart.Picker({
  theme: "light",
  skinTonePosition: "none",
  previewPosition: "none",
  onEmojiSelect: (emoji) => {
    const { selectionStart: start, selectionEnd: end } = messageInput;
    messageInput.setRangeText(emoji.native, start, end, "end");
    messageInput.focus();
  },
  onClickOutside: (e) => {
    if (e.target.id === "emoji-picker") {
      document.body.classList.toggle("show-emoji-picker");
    } else {
      document.body.classList.remove("show-emoji-picker");
    }
  },
});

document.querySelector(".chat-form").appendChild(picker);

sendMessage.addEventListener("click", (e) => handleOutgoingMessage(e));
document.querySelector("#file-upload").addEventListener("click", () => fileInput.click());
closeChatbot.addEventListener("click", () => document.body.classList.remove("show-chatbot"));
chatbotToggler.addEventListener("click", () => document.body.classList.toggle("show-chatbot"));