package data_transfer_objects;

import entity.FlightDetail;

import java.util.stream.Collectors;

public class FlightDetailToDTOMapper {

    public FlightDetailDataTransferObject map(FlightDetail entity) {
        return new FlightDetailDataTransferObject(
                entity.id,
                entity.numberOfBookableSeats,
                mapPrice(entity.price),
                entity.fareOption,
                entity.segments.stream()
                        .map(this::mapSegment)
                        .collect(Collectors.toList())
        );
    }

    private FlightDetailDataTransferObject.PriceDTO mapPrice(FlightDetail.Price price) {
        return new FlightDetailDataTransferObject.PriceDTO(
                price.total,
                price.currency
        );
    }

    private FlightDetailDataTransferObject.SegmentDTO mapSegment(FlightDetail.SegmentDetail seg) {
        return new FlightDetailDataTransferObject.SegmentDTO(
                seg.departureAirport,
                seg.departureTime,
                seg.departureTerminal,
                seg.arrivalAirport,
                seg.arrivalTime,
                seg.arrivalTerminal,
                seg.carrierCode,
                seg.flightNumber,
                seg.aircraft,
                seg.duration,
                seg.cabinClass,
                mapBaggage(seg.baggage),
                seg.amenities.stream()
                        .map(this::mapAmenity)
                        .collect(Collectors.toList())
        );
    }

    private FlightDetailDataTransferObject.BaggageDTO mapBaggage(FlightDetail.Baggage b) {
        return new FlightDetailDataTransferObject.BaggageDTO(
                b.checkedBags,
                b.cabinBags
        );
    }

    private FlightDetailDataTransferObject.AmenityDTO mapAmenity(FlightDetail.Amenity a) {
        return new FlightDetailDataTransferObject.AmenityDTO(
                a.description,
                a.amenityType,
                a.isChargeable
        );
    }
}

