/**
 * 
 */
package com.promineotech.jeep.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.jeep.entity.Color;
import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Engine;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.entity.Tire;

/**
 * @author UJJVAL
 *
 */
public interface JeepOrderDao {

  /**
   * @param orderRequest
   * @return
   */
  Order createOrder(OrderRequest orderRequest);

  /**
   * @param optionIds
   * @return
   */
  List<Option> fetchOptions(List<String> optionIds);

  /**
   * @param customerId
   * @return
   */
  Optional<Customer> fetchCustomer(String customerId);

  /**
   * @param model
   * @param trim
   * @param doors
   * @return
   */
  Optional<Jeep> fetchModel(JeepModel model, String trim, int doors);

  /**
   * @param colorId
   * @return
   */
  Optional<Color> fetchColor(String colorId);

  /**
   * @param engineId
   * @return
   */
  Optional<Engine> fetchEngine(String engineId);

  /**
   * @param tireId
   * @return
   */
  Optional<Tire> fetchTire(String tireId);


  /**
   * @param customer
   * @param jeep
   * @param color
   * @param engine
   * @param tire
   * @param price
   * @param options
   * @return
   */
  Order saveOrder(Customer customer, Jeep jeep, Color color, Engine engine, Tire tire,
      BigDecimal price, List<Option> options);

}
