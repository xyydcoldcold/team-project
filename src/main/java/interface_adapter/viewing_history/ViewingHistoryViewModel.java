package interface_adapter.viewing_history;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Viewing History View.
 */

public class ViewingHistoryViewModel extends ViewModel<ViewingHistoryState> {

    public ViewingHistoryViewModel() {
        super("viewing history");
        setState(new ViewingHistoryState());
    }
}
