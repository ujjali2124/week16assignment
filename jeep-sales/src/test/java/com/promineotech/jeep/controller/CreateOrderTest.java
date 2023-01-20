/**
 * 
 */
package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.web.server.ResponseStatusException;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.promineotech.jeep.controller.support.CreateOrderTestSupport;
import com.promineotech.jeep.entity.JeepModel;

/**
 * @author UJJVAL
 *
 */

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
    "classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
    config = @SqlConfig(encoding = "utf-8"))
class CreateOrderTest extends CreateOrderTestSupport {
  
  @Test
  void testCreateOrderReturnsSuccess201() {
   String body = createOrderBody();
   String uri = getBaseUriForOrders();
   
   HttpHeaders hearders = new HttpHeaders();
   hearders.setContentType(MediaType.APPLICATION_JSON);
   
   
   HttpEntity<String> bodyEntity = new HttpEntity<>(body, hearders);
   
   ResponseEntity<com.promineotech.jeep.entity.Order> response = getRestTemplate().exchange(uri, HttpMethod.POST, bodyEntity, com.promineotech.jeep.entity.Order.class);
   
   assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
   
   assertThat(response.getBody()).isNotNull();
   
   com.promineotech.jeep.entity.Order order = response.getBody();
   assertThat(order.getCustomer().getCustomerId()).isEqualTo("MORISON_LINA");
   assertThat(order.getModel().getModelId()).isEqualTo(JeepModel.WRANGLER);
   assertThat(order.getModel().getTrimLevel()).isEqualTo("Sport Altitude");
   assertThat(order.getModel().getNumDoors()).isEqualTo(4);
   assertThat(order.getColor().getColorId()).isEqualTo("EXT_NACHO");
   assertThat(order.getEngine().getEngineId()).isEqualTo("2_0_TURBO");
   assertThat(order.getTire().getTireId()).isEqualTo("35_TOYO");
   assertThat(order.getOptions()).hasSize(6);

  }

}
