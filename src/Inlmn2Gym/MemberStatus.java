package Inlmn2Gym;

public enum MemberStatus {
    EXISTING_MEMBER("Existing member"),
    EXPIRED_MEMBER("Expired member"),
    UNKNOWN_MEMBER("Unknown member");

    public final String memberStatus; //ett meddelande som kommer ut via varje status

    MemberStatus(String s) {
        memberStatus = s;
    }
}


