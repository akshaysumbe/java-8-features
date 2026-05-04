package optional.service;

import optional.model.Restaurant;
import optional.repository.RestaurantRepository;

import java.util.Optional;

public class RestaurantService {
    RestaurantRepository repository = new RestaurantRepository();

    public Optional<Restaurant> findRestaurant(String restaurantId) {
        return Optional.ofNullable(repository.findById(restaurantId));
    }
}
