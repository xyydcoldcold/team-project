package use_case.view_history;

/**
 * The Input Data for the View History Use Case.
 */

public class ViewHistoryInputData {

    private final String username;

    public ViewHistoryInputData(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
