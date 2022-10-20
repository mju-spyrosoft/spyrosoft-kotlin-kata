package _2_null_safety.exercise.null_allowed;

public class NullableTypes {
    public void sendMessageToClient(
            ClientJ client,
            String message,
            MailerJ mailer
    ) {
        if (client == null || message == null) return;

        PersonalInfoJ personalInfo = client.getPersonalInfo();
        if (personalInfo == null) return;

        String email = personalInfo.getEmail();
        if (email == null) return;

        mailer.sendMessage(email, message);
    }


    public static void main(String[] args) {
        NullableTypes nullableTypes = new NullableTypes();

        ClientJ mail = new ClientJ(new PersonalInfoJ("Mail"));
        nullableTypes.sendMessageToClient(mail, "Java hello kata", (email, message) -> System.out.println(message));
    }
}

class ClientJ {
    private final PersonalInfoJ personalInfo;

    public ClientJ(PersonalInfoJ personalInfo) {
        this.personalInfo = personalInfo;
    }

    public PersonalInfoJ getPersonalInfo() {
        return personalInfo;
    }
};

class PersonalInfoJ {
    private final String email;

    public PersonalInfoJ(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
};

interface MailerJ {
    void sendMessage(String email, String message);
}
