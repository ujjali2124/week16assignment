/**
 * 
 */
package com.promineotech.jeep.entity;
import java.lang.*;
import java.math.BigDecimal;
import java.util.Comparator;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author UJJVAL
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Jeep implements Comparable<Jeep>{
  private Long modelPK;
  private JeepModel modelId;
  private String trimLevel;
  private int numDoors;
  private int wheelSize;
  private BigDecimal basePrice;
  

  @JsonIgnore
  public long getModelPK() {
    return modelPK;
  }
  /**
   * @param uri
   * @param class1
   * @return
   */
  //public ResponseEntity<Jeep> getForEntity(String uri, Class<Jeep> class1) {
    // TODO Auto-generated method stub
    //return null;
  //}
  /**
   * @return
   */
  //public static JeepBuilder builder() {
    // TODO Auto-generated method stub
    //return null;
 // }
  @Override
  public int compareTo(Jeep that) {
    
    // @formatter:off
    return Comparator
        .comparing(Jeep::getModelId)
        .thenComparing(Jeep::getTrimLevel)
        .thenComparing(Jeep::getNumDoors)
        .compare(this, that);
    // @formatter:on

    
    
  }


}
