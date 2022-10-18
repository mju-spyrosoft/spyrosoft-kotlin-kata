package _2_null_saftey.exercise.null_not_allowed;


public class NonNullable {
    public void sendMessageToClient(
            ClientJ client,
            String message,
            MailerJ mailer
    ) {
        if (client == null) {
            throw new NullPointerException("client must be non null");
        }
        if (message == null) {
            throw new NullPointerException("message must be non null");
        }

        PersonalInfoJ personalInfo = client.getPersonalInfo();
        String email = personalInfo.getEmail();

        mailer.sendMessage(email, message);
    }


    public static void main(String[] args) {
        NonNullable nullableTypes = new NonNullable();

        ClientJ mail = new ClientJ(new PersonalInfoJ("Mail"));
        nullableTypes.sendMessageToClient(mail, "Java hello kata", (email, message) -> System.out.println(message));

        //Does compile, fails at runtime
        ClientJ failed = new ClientJ(null);
        nullableTypes.sendMessageToClient(null, "Java hello kata", (email, message) -> System.out.println(message));
    }
}

class ClientJ {
    private final PersonalInfoJ personalInfo;

    public ClientJ(PersonalInfoJ personalInfo) {
        if(personalInfo == null){
            throw new NullPointerException("personalInfo must be non null");
        }

        this.personalInfo = personalInfo;
    }

    public PersonalInfoJ getPersonalInfo() {
        return personalInfo;
    }
};

class PersonalInfoJ {
    private final String email;

    public PersonalInfoJ(String email) {
        if(email == null){
            throw new NullPointerException("personalInfo must be non null");
        }

        this.email = email;
    }

    public String getEmail() {
        return email;
    }
};

interface MailerJ {
    void sendMessage(String email, String message);
}
