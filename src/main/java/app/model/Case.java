package app.model;

import javax.persistence.*;

/**
 * This class describes case entity
 *
 * @author Kadochnikov Sregey
 */

@Entity
@Table(name = "cases")
public class Case {

    public Case() {
    }

    public Case(String name, String description, String time) {
        this.name = name;
        this.description = description;
        this.time = time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private String time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
