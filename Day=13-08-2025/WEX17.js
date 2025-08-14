// Quiz questions
let questions = [
    {
        question: "What is the capital of France?",
        options: ["Berlin", "Madrid", "Paris", "Rome"],
        answer: "Paris"
    },
    {
        question: "Which planet is known as the Red Planet?",
        options: ["Earth", "Mars", "Jupiter", "Venus"],
        answer: "Mars"
    },
    {
        question: "Who wrote 'Hamlet'?",
        options: ["Charles Dickens", "William Shakespeare", "Mark Twain", "Leo Tolstoy"],
        answer: "William Shakespeare"
    }
];

let currentQuestionIndex = 0;
let score = 0;

// Display question
function loadQuestion() {
    let questionElement = document.getElementById("question");
    let optionsElement = document.getElementById("options");
    let feedbackElement = document.getElementById("feedback");

    feedbackElement.textContent = "";
    let q = questions[currentQuestionIndex];
    questionElement.textContent = q.question;

    optionsElement.innerHTML = "";
    q.options.forEach(option => {
        let btn = document.createElement("button");
        btn.textContent = option;
        btn.className = "option-btn";
        btn.onclick = function () {
            checkAnswer(option);
        };
        optionsElement.appendChild(btn);
    });
}

// Check answer
function checkAnswer(selected) {
    let feedbackElement = document.getElementById("feedback");
    if (selected === questions[currentQuestionIndex].answer) {
        feedbackElement.textContent = "✅ Correct!";
        score++;
    } else {
        feedbackElement.textContent = "❌ Wrong!";
    }
    document.getElementById("score").textContent = "Score: " + score;
}

// Load next question
function nextQuestion() {
    currentQuestionIndex++;
    if (currentQuestionIndex < questions.length) {
        loadQuestion();
    } else {
        document.getElementById("question").textContent = "Quiz Completed!";
        document.getElementById("options").innerHTML = "";
        document.getElementById("feedback").textContent = `Final Score: ${score}/${questions.length}`;
        document.getElementById("nextBtn").style.display = "none";
    }
}

// Initialize quiz
window.onload = loadQuestion;
