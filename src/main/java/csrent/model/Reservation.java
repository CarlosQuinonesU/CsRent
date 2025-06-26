package csrent.model;

import csrent.model.space.Space;
import csrent.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_mail", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name= "space_id", nullable = false)
    private Space space;
    private LocalDate dateReservacion;
    private String status;

    public Reservation() {
    }

    public Reservation(Integer id, User user, Space space, LocalDate dateReservacion, String status) {
        this.id = id;
        this.user = user;
        this.space = space;
        this.dateReservacion = dateReservacion;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public LocalDate getDateReservacion() {
        return dateReservacion;
    }

    public void setDateReservacion(LocalDate dateReservacion) {
        this.dateReservacion = dateReservacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", space=" + space +
                ", dateReservacion=" + dateReservacion +
                ", status='" + status + '\'' +
                '}';
    }
}
