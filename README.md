# grokonez-sdf-jackson

- ## Entity
  - ```
    @Entity
    @Table(name="datetiemmodel")
    class DateTimeModel {
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
    
      @Column
      @Temporal(TemporalType.Date)
      @JsonFormat(pattern="yyyy-MM-dd)
      Date date;
      
      @Column
      @Temporal(TemporalType.TIMESTAMP)
      @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
      Date dateTime;
      
      @Column
      @Temporal(TemporalType.TIMESTAMP)
      @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Paris")
      Date dateTimeWithZone;
      
      @Column
      @Temporal(TemporalType.TIMESTAMP)
      Date dateTimeDefaultFormat;
      
    
    }
    ```
- ## Repository
  - ```
    @Repository
    interface DateTimeModelRepository implements CrudRepository<DateTimeModel, Long> {
      List<DateTimeModel> findAllByDateTimeBetween(Date startDate, endDate);
      
      @Query("select d from DateTimeModel d where d.dateTime <= :dateTime)
      List<DateTimeModel> findAllWithDateTimeBefore(@Param("dateTime") Date dateTime);
    
    }
    ```
- ## Controller
  - ```
    @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-mm-dd HH:mm:ss") Date startDate
    ```
- ## Properties
  - ```
    spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
    spring.jackson.time-zone=Asia/Ho_Chi_Minn
    ```
