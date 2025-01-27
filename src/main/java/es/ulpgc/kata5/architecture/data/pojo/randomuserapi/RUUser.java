package es.ulpgc.kata5.architecture.data.pojo.randomuserapi;

public record RUUser(
        String gender,
        Name name,
        String email,
        Picture picture
) {
    public record Name(String title, String first, String last) { }

    public record Picture(String large, String medium, String thumbnail) { }
}
