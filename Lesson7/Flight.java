public class Flight
{
   private int _seats;
   private int _booked;
   private Date _flightDate;
   private String _destination;
   private String _origin;
  
   public Flight (int seats, Date date,String dest,String origin)
   {
       _seats=seats;
       _booked=0;
       _flightDate=new Date(date);
       _destination=dest;
       _origin=origin;
    }
    //Copy constructor
    public Flight (Flight other)
   {
       _seats=other._seats;
       _booked=other._booked;
       _flightDate=new Date(other._flightDate);
       _destination=other._destination;
       _origin=other._origin;
    }
    
    public int getSeats()
    { 
         return _seats;
        }
    public int getBooked()
    { 
         return _booked;
        }
     public Date getFlightDate()
    { 
         return new Date (_flightDate);
        }
     public String getDestination()
    { 
         return _destination;
        }
     public String getOrigin()
    { 
         return _origin;
        }   
     public void setSeats(int seats)
    { 
          _seats=seats;
        }
    public void  setBooked(int booked)
    { 
          _booked=booked;
        }
     public void setFlightDate(Date newDate)
    { 
         _flightDate=new Date(newDate);
        }
     public void setDestination(String dest)
    { 
         _destination=dest;
        }
     public void setOrigin(String origin)
    { 
         _origin=origin;
        }   
        
      public String toString()
    {
      return (" Date : "+_flightDate+"\nDestination: "+_destination+
      "\nOrigin: "+_origin+ "\nCapacity :"+  _seats+ "\nBooked: "+_booked);
    }
    public boolean equals(Flight other){
            if (_flightDate.equals(other._flightDate)&&_destination.equals(other._destination)&&_origin.equals(other._origin))
                      return true;
            return false;
            }
     public boolean full(){
         if (_booked==_seats )
                  return true;
         return false;
        }
        public int placesLeft(){
              return _seats-_booked;
            }
         public boolean book(int places)
         { 
             if (places <=placesLeft())
                     {
                         _booked+=places;
                         return true;
                        }   
              return false;
            }
        }
   