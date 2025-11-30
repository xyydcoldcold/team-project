package use_case.save_flight;

import entity.FlightDetail;
import data_transfer_objects.FlightDetailDataTransferObject;
import data_transfer_objects.FlightDetailToDTOMapper;
import data_transfer_objects.DTOToFlightDetailMapper;
import data_access.FileUserDataAccessObject; // assume this exists

public class SaveFlightInteractor implements SaveFlightInputBoundary {

    private final SaveFlightDataAccessInterface flightGateway;
    private final FileUserDataAccessObject userGateway;
    private final SaveFlightOutputBoundary presenter;

    public SaveFlightInteractor(
            SaveFlightDataAccessInterface flightGateway,
            FileUserDataAccessObject userGateway,
            SaveFlightOutputBoundary presenter) {
        this.flightGateway = flightGateway;
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

    @Override
    public void execute(SaveFlightInputData inputData) {
        if (inputData == null || inputData.getFlightDetail() == null) {
            presenter.prepareFailView(new SaveFlightOutputData(false, "No flight selected to save."));
            return;
        }

        FlightDetailDataTransferObject detailDTO = inputData.getFlightDetail();
        DTOToFlightDetailMapper mapper = new DTOToFlightDetailMapper();

        FlightDetail detail = mapper.map(detailDTO);


        String flightId = inputData.getFlightId();

        if (flightId == null || flightId.isEmpty()) {
            presenter.prepareFailView(new SaveFlightOutputData(false, "Flight has no ID; cannot save."));
            return;
        }

        String username = userGateway.getCurrentUsername();
        if (username == null || username.isEmpty()) {
            presenter.prepareFailView(new SaveFlightOutputData(false, "No logged-in user found."));
            return;
        }

        try {
            if (flightGateway.flightExistsForUser(username, flightId)) {
                presenter.prepareFailView(new SaveFlightOutputData(false, "This flight is already saved."));
                return;
            }

            flightGateway.saveFlightForUser(username, detail);

            FlightDetailToDTOMapper mapperDTO = new FlightDetailToDTOMapper();
            FlightDetailDataTransferObject detailDto = mapperDTO.map(detail);

            presenter.prepareSuccessView(
                    new SaveFlightOutputData(true, "Flight saved successfully!", detailDto)
            );
        } catch (Exception e) {
            e.printStackTrace();
            presenter.prepareFailView(new SaveFlightOutputData(false, "Failed to save flight: " + e.getMessage()));
        }
    }
}

