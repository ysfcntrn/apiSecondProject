package Team66PojoPackage;

public class Squad {
//    "id": 3188,
//            "name": "David De Gea",
//            "position": "Goalkeeper",
//            "dateOfBirth": "1990-11-07T00:00:00Z",
//            "countryOfBirth": "Spain",
//            "nationality": "Spain",
//            "shirtNumber": null,
//            "role": "PLAYER"
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String position;
    private String dateOfBirth;
    private String countryOfBirth;
    private String nationality;
    private String shirtNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(String shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;
}
