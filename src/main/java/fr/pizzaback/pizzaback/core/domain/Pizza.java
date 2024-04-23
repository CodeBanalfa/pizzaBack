package fr.pizzaback.pizzaback.core.domain;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; // Ajout de l'import pour l'annotation @GeneratedValue
import jakarta.persistence.GenerationType; // Ajout de l'import pour l'annotation @GeneratedValue
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Utilisation de @GeneratedValue pour les ID auto-incrémentés
    @Column(name = "id")
    private Short id;

    @Column(name = "name", nullable = false) // Ajout de nullable = false pour s'assurer qu'il y a toujours un nom
    private String name;
    
    @Column(name = "description", nullable = false) // Ajout de nullable = false pour s'assurer qu'il y a toujours une description
    private String description;
    
    @Column(name = "image") 
    private String image; 
    
    @Column(name = "price", nullable = false) // Ajout de nullable = false pour garantir qu'il y a toujours un prix
    private BigDecimal price;

    public Pizza() {
        // Le constructeur par défaut est déjà ici
    }

    // Getters et Setters
    public Short getId() {
        return id;
    }

    public void setId(Short id) { // Correction : Utilisez le paramètre d'entrée pour mettre à jour l'attribut
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) { // Correction : L'argument doit mettre à jour l'attribut
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", price=" + price + "]";
    }
}
