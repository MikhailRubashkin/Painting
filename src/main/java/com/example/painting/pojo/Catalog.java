package com.example.painting.pojo;





import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity(name = "Catalog")
@Table(name = "catalog")
public class Catalog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itName;
    @Lob
    private byte[] productImage;


    public Catalog(){}

    public Catalog ( String itName ){
        this.itName = itName;
    }

    public Long getId (){
        return id;
    }

    public void setId ( Long id ){
        this.id = id;
    }

    public String getItName (){
        return itName;
    }

    public void setItName ( String itName ){
        this.itName = itName;
    }

    public byte[] getProductImage (){
        return productImage;
    }

    public void setProductImage ( byte[] productImage ){
        this.productImage = productImage;
    }

    @Override
    public boolean equals ( Object o ){
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;

        Catalog catalog = (Catalog) o;

        if (id != null ? !id.equals (catalog.id) : catalog.id != null) return false;
        if (itName != null ? !itName.equals (catalog.itName) : catalog.itName != null) return false;
        return Arrays.equals (productImage, catalog.productImage);
    }

    @Override
    public int hashCode (){
        int result = id != null ? id.hashCode ( ) : 0;
        result = 31 * result+(itName != null ? itName.hashCode ( ) : 0);
        result = 31 * result+Arrays.hashCode (productImage);
        return result;
    }

    @Override
    public String toString (){
        return "Catalog{"+
               "id="+id+
               ", itName='"+itName+'\''+
               ", productImage="+Arrays.toString (productImage)+
               '}';
    }
}
