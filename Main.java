import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Singleton pattern used for managing personality types
class PersonalityTypes {
    private static final PersonalityTypes instance = new PersonalityTypes();
    private Map<String, String> personalityMap;

    private PersonalityTypes() {
        personalityMap = new HashMap<>();
        // Initialize with some example personality types and descriptions
        personalityMap.put("INTJ", "Architect: Imaginative and strategic thinkers with a plan for everything.");
        personalityMap.put("INFP", "Mediator: Poetic, kind, and altruistic people, always eager to help.");
        // Add more personality types and descriptions as needed
    }

    public static PersonalityTypes getInstance() {
        return instance;
    }

    public void addPersonalityType(String type, String description) {
        personalityMap.put(type, description);
    }

    public String getDescription(String type) {
        return personalityMap.get(type);
    }
}

// Factory method pattern used for creating personality types based on test result
class PersonalityFactory {
    public static String createPersonalityType(int score) {
        // Assign personality type based on the score range (This is a simplified version)
        if (score >= 25) {
            return "INTJ";
        } else {
            return "INFP";
        }
        // Add more conditions and personality types as needed
    }
}

// Observer pattern used to notify users about their personality type
interface PersonalityObserver {
    void update(String personalityType);
}

class User implements PersonalityObserver {
    private String name;
    private String personalityType;

    public User(String name) {
        this.name = name;
    }

    public void solveTest() {
        // Simulated test with 10 questions (This is a simplified version)
        // Users choose an option from 1 to 5 for each question
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        String question = null;

        System.out.println("Please answer the following questions (Choose options from 1 to 5):");
        // Simulated questions
        // Replace these questions with actual questions in your application
        for (int i = 1; i <= 20; i++) {
            if(i == 1){
                question = "You regularly make new friends.";
            }
            else if(i ==2){
                question = "You spend a lot of your free time exploring various random topics that pique your interest.";
            }
            else if(i == 3){
                question = "Seeing other people cry can easily make you feel like you want to cry too.";
            }
            else if(i == 4){
                question = "You often make a backup plan for a backup plan.";
            }
            else if (i == 5) {
                question = "You usually stay calm, even under a lot of pressure.";
            }
            else if(i == 6){
                question = "At social events, you rarely try to introduce yourself to new people and mostly talk to the ones you already know.";
            }
            else if(i == 7){
                question = "You prefer to completely finish one project before starting another.";
            }
            else if(i == 8){
                question = "You are very sentimental.";
            }
            else if(i == 9){
                question = "You like to use organizing tools like schedules and lists.";
            }
            else if(i == 10){
                question = "Even a small mistake can cause you to doubt your overall abilities and knowledge.";
            }
            else if(i == 11){
                question = "You feel comfortable just walking up to someone you find interesting and striking up a conversation.";
            }
            else if(i == 12){
                question = "You are not too interested in discussing various interpretations and analyses of creative works.";
            }
            else if(i == 13){
                question = "You are more inclined to follow your head than your heart.";
            }
            else if(i == 14){
                question = "You usually prefer just doing what you feel like at any given moment instead of planning a particular daily routine.";
            }
            else if(i == 15){
                question = "You rarely worry about whether you make a good impression on people you meet.";
            }
            else if(i == 16){
                question = "You enjoy participating in group activities.";
            }
            else if(i ==17){
                question = "You like books and movies that make you come up with your own interpretation of the ending.";
            }
            else if(i == 18){
                question = "Your happiness comes more from helping others accomplish things than your own accomplishments.";
            }
            else if( i == 19){
                question = "You are interested in so many things that you find it difficult to choose what to try next.";
            }
            else {
                question = "You are prone to worrying that things will take a turn for the worse.";
            }
            System.out.println("Question " + i + ":" );
            System.out.println(question);
            System.out.println("Choose from 1-5, 1 mean you agree and 5 mean you disagree:");
            int choice = scanner.nextInt();
            totalScore += choice;
        }

        PersonalityTypes personalityTypes = PersonalityTypes.getInstance();
        personalityType = PersonalityFactory.createPersonalityType(totalScore);

        // Notify the user about their personality type
        update(personalityType);
    }

    @Override
    public void update(String personalityType) {
        this.personalityType = personalityType;
        System.out.println("Dear " + name + ", your personality type is: " + personalityType);
        System.out.println("Description: " + PersonalityTypes.getInstance().getDescription(personalityType));
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("John"); // Replace "John" with the user's name
        user.solveTest();
    }
}
