package app.dao;

import app.model.Case;
import java.util.List;

public interface CaseDao {

    /**
     * This method returns a list of all existing cases
     *
     * @return A collection of case objects
     */
    List<Case> getAll();

    /**
     *This method returns one case object by id
     *
     * @param id unique identifier of case object
     * @return case object
     */
    Case getOne(int id);

    /**
     * This method adds one case object to repository
     *
     * @param name value received from the user. Is a name of new case object
     * @param time value received from the user. Is a time of new case object
     * @param description value received from the user. Is a description of new case object
     */
    void addCase(String name, String time, String description);

    /**
     * This method deletes the case object being updated
     * and creates new case object with updated values
     * and adds it to repository
     *
     * @param id unique identifier of case object. Value not received from the user
     * @param name value received from the user. Updated name value
     * @param time value received from the user. Updated time value
     * @param description value received from the user. Updated description value
     */
    void updateCase(int id, String name, String time, String description);

    /**
     * This method deletes one case object from repository by id
     *
     * @param id unique identifier of case object
     */
    void deleteCase(int id);

}
