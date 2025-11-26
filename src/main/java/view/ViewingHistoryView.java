package view;

import entity.FlightSearchInformation;
import interface_adapter.viewing_history.ViewingHistoryState;
import interface_adapter.viewing_history.ViewingHistoryViewModel;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for when the user clicks on the "See History" button from the Logged In view.
 */

public class ViewingHistoryView extends JPanel implements ActionListener, PropertyChangeListener {


    private final String viewName = "viewing history";
    private final ViewingHistoryViewModel viewingHistoryViewModel;

    // TODO: Implement the LoadHistoryController
    // private LoadHistoryController loadHistoryController;

    private final JLabel titleLabel;
    private final JButton goBack;
    private final JButton loadSelection;
    private final JTable historyTable;
    private final DefaultTableModel tableModel;
    private final JScrollPane tableScrollPane;

    public ViewingHistoryView(ViewingHistoryViewModel viewingHistoryViewModel) {
        this.viewingHistoryViewModel = viewingHistoryViewModel;
        this.viewingHistoryViewModel.addPropertyChangeListener(this);

        // Set up title label
        this.titleLabel = new JLabel("Search History");
        this.titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set up buttons
        JPanel buttons = new JPanel();
        this.goBack = new JButton("Go Back");
        this.loadSelection = new JButton("Load Selection");
        buttons.add(goBack);
        buttons.add(loadSelection);

        // Set up table
        String[] columnTitles = {"Date", "Time", "From", "To", "Day of Arrival", "Month of Arrival", "Year of Arrival"};

        this.tableModel = new DefaultTableModel(columnTitles, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.historyTable = new JTable(this.tableModel);

        // Add to scroll pane
        this.tableScrollPane = new JScrollPane(this.historyTable);
        this.tableScrollPane.setPreferredSize(new Dimension(800, 300));

        // Set layout and add components
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titleLabel);
        this.add(tableScrollPane);
        this.add(buttons);

        // Add selection listener to table
        this.historyTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {

                // Handles updating the selected entry in the state
                int row = historyTable.getSelectedRow();
                final ViewingHistoryState currentState = this.viewingHistoryViewModel.getState();
                currentState.setSelectedEntry(currentState.getSearchHistory().get(row));
                this.viewingHistoryViewModel.setState(currentState);
            }
        });


    }

    private void initializeHistoryTable(List<FlightSearchInformation> searchHistory) {

        // Clear existing rows
        this.tableModel.setRowCount(0);

        // Populate and add rows to the table
        for (FlightSearchInformation search:  searchHistory) {
            Object[] row = {search.getDateOfSearch(), search.getTimeOfSearch(), search.getFrom(),
                    search.getTo(), search.getDay(), search.getMonth(), search.getYear()};

            this.tableModel.addRow(row);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final ViewingHistoryState state = (ViewingHistoryState) evt.getNewValue();

        if (evt.getPropertyName().equals("initialize success view")) {
            List<FlightSearchInformation> searchHistory =  state.getSearchHistory();
            initializeHistoryTable(searchHistory);
        }

    }

    public String getViewName() {
        return viewName;
    }
}
