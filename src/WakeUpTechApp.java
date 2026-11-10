import java.util.ArrayList;
import java.util.Scanner;

// Question class to structure each reality-check and AI trend question
class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex; // 0-based index

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void display() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int userAnswer) {
        return (userAnswer - 1) == correctAnswerIndex;
    }
}

public class WakeUpTechApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("   WAKEUP-TECH: STUDENT COMPETITIVENESS ANALYZER  ");
        System.out.println("==================================================");
        System.out.print("Enter your name to begin your reality check: ");
        String name = scanner.nextLine();

        System.out.println("\nHello, " + name + ". Let's test your global tech awareness and mindset.");
        System.out.println("Loading your assessment...\n");

        // Simulating a brief delay using multithreading concept (Thread.sleep)
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Interruption caught!");
        }

        // Creating our list of 10 questions (AI Trends with 5 options + Student Reality Check)
        ArrayList<Question> quizList = new ArrayList<>();

        // Question 1: AI Trends (Hardware & Inference Shift) - 5 options
        quizList.add(new Question(
            "[AI Trend] With inference overtaking training and synthetic data driving frontier reasoning, how is hardware demand evolving?",
            new String[] {
                "Shifting toward low-latency, memory-centric inference accelerators and specialized silicon.",
                "Sticking exclusively to traditional single-core CPUs.",
                "Abandoning all physical hardware for cloud-free paper computing.",
                "Relying solely on vintage 1990s desktop processors.",
                "Don't know"
            }, 
            0 // Correct option is 1 (index 0)
        ));

        // Question 2: AI Trends (Multi-Agent Safety) - 5 options
        quizList.add(new Question(
            "[AI Trend] As multi-agent systems and agentic workflows advance, what architectural safeguard is critical?",
            new String[] {
                "Allowing agents to operate completely unmonitored with zero constraints.",
                "Preventing cascading errors, reward hacking, and ensuring alignment across agents.",
                "Deleting all code after every single execution.",
                "Hardcoding every single user response manually.",
                "Don't know"
            }, 
            1 // Correct option is 2 (index 1)
        ));

        // Question 3: AI Trends (AI for Science) - 5 options
        quizList.add(new Question(
            "[AI Trend] As AI foundation models transition into autonomous experimental designers for science, what is required?",
            new String[] {
                "Blindly trusting every machine-generated output without testing.",
                "Rigorous verification and validation standards before trusting agent hypotheses.",
                "Stopping all physical laboratory experiments forever.",
                "Using random number generators to verify data.",
                "Don't know"
            }, 
            1 // Correct option is 2 (index 1)
        ));

        // Question 4: Reality Check (Debugging & Resilience)
        quizList.add(new Question(
            "[Reality Check] When a complex bug breaks your code during a personal project, what do you do?",
            new String[] {
                "Close the laptop out of frustration and complain that coding is too hard.",
                "Analyze logs, search documentation, debug independently, and solve it.",
                "Ask someone else to write the entire codebase for you.",
                "Delete the project and pretend it never existed."
            }, 
            1
        ));

        // Question 5: Reality Check (Tier-3 Mindset)
        quizList.add(new Question(
            "[Reality Check] How do you view studying in a tier-3 engineering college?",
            new String[] {
                "A dead-end where nobody can ever succeed or build a career.",
                "A launchpad: the internet provides the same global knowledge and opportunities to everyone.",
                "An excuse to stop learning and blame external conditions.",
                "Just a place to collect a physical degree certificate."
            }, 
            1
        ));

        // Question 6: Reality Check (Git & Version Control)
        quizList.add(new Question(
            "[Reality Check] How frequently do you use version control (Git/GitHub) and build software outside of class?",
            new String[] {
                "Only the night before a university lab practical exam.",
                "Never; university lecture notes are more than enough.",
                "Consistently, maintaining an active portfolio of personal projects.",
                "Only when forced by social media trends."
            }, 
            2
        ));

        // Question 7: Reality Check (Ethical AI Usage)
        quizList.add(new Question(
            "[Reality Check] What is your approach toward using AI coding assistants and modern tech tools?",
            new String[] {
                "Blindly copy-pasting code without understanding how it works.",
                "Using them ethically to accelerate learning, debugging, and software engineering execution.",
                "Ignoring them entirely because they aren't in the printed textbook.",
                "Using them only to cheat on assignments."
            }, 
            1
        ));

        // Question 8: Reality Check (Continuous Learning)
        quizList.add(new Question(
            "[Reality Check] What does continuous learning mean for an aspiring AI/ML or Software Engineer?",
            new String[] {
                "Stopping all technical education the day you graduate.",
                "Adapting continuously to new tech stacks, frameworks, and paradigms as the industry evolves.",
                "Reading only the exact pages marked for the semester exam.",
                "Learning only when forced by a manager."
            }, 
            1
        ));

        // Question 9: Reality Check (Campus Dependency)
        quizList.add(new Question(
            "[Reality Check] If top tech recruiters do not visit your campus placement cell, what is your next step?",
            new String[] {
                "Sit back, do nothing, and blame the college placement office.",
                "Build projects, showcase skills on GitHub, and apply aggressively off-campus.",
                "Quit engineering entirely.",
                "Protest outside the administration block."
            }, 
            1
        ));

        // Question 10: Reality Check (Core Mastery)
        quizList.add(new Question(
            "[Reality Check] When faced with a challenging concept in your AI & ML stream, your reaction is:",
            new String[] {
                "Memorize definitions word-for-word just to pass the exam.",
                "Break down the logic, write test scripts in Python, and truly master it.",
                "Skip the topic completely and hope it's not on the question paper.",
                "Complain that the syllabus is too modern."
            }, 
            1
        ));

        int score = 0;

        // Running the quiz loop with dynamic option validation (1-5 for first 3 questions, 1-4 for others)
        for (int i = 0; i < quizList.size(); i++) {
            Question q = quizList.get(i);
            q.display();
            
            // Determine max options allowed for this specific question (5 for first 3, 4 for the rest)
            int maxOption = (i < 3) ? 5 : 4;
            
            int choice = -1;
            while (true) {
                System.out.print("Your choice (1-" + maxOption + "): ");
                try {
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        if (choice >= 1 && choice <= maxOption) {
                            break;
                        } else {
                            System.out.println("❌ Invalid option! Please choose between 1 and " + maxOption + ".");
                        }
                    } else {
                        String badInput = scanner.next();
                        System.out.println("❌ Error: '" + badInput + "' is not a valid number. Try again.");
                    }
                } catch (Exception e) {
                    System.out.println("❌ An error occurred. Please enter a valid number.");
                }
            }

            if (q.isCorrect(choice)) {
                System.out.println("✔ Correct! You see the reality.");
                score++;
            } else {
                System.out.println("✖ Incorrect. That's a comfort-zone mindset.");
            }
        }

        // Final Reality Check Evaluation
        System.out.println("\n==================================================");
        System.out.println("               YOUR REALITY REPORT                ");
        System.out.println("==================================================");
        System.out.println("Student: " + name);
        System.out.println("Score: " + score + " / " + quizList.size());

        double percentage = ((double) score / quizList.size()) * 100.0;
        System.out.println("Readiness Index: " + percentage + "%");

        if (score >= 8) {
            System.out.println("\n🔥 HUSTLER TIER: Outstanding awareness! You understand both high-level AI tech shifts and execution-driven realities. Keep building daily and ship your code!");
        } else if (score >= 5) {
            System.out.println("\n⚠️ WAKE-UP STAGE: You have flashes of awareness, but you're still half-asleep in the college bubble. Step up your coding frequency, break the tier-3 ceiling, and dive into real projects.");
        } else {
            System.out.println("\n🚨 DANGER ZONE - COMFORT TRAP: You are entirely disconnected from global competition. Relying on textbook memos and waiting for spoon-fed opportunities will cost you your career. Wake up and start building today!");
        }

        scanner.close();
    }
}