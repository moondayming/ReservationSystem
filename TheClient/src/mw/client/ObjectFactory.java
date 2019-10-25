
package mw.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mw.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Hasexportnumber_QNAME = new QName("http://service.mw/", "hasexportnumber");
    private final static QName _HasexportnumberResponse_QNAME = new QName("http://service.mw/", "hasexportnumberResponse");
    private final static QName _Cancel_QNAME = new QName("http://service.mw/", "cancel");
    private final static QName _CancelResponse_QNAME = new QName("http://service.mw/", "cancelResponse");
    private final static QName _ReservationResponse_QNAME = new QName("http://service.mw/", "reservationResponse");
    private final static QName _Subexpertnum_QNAME = new QName("http://service.mw/", "subexpertnum");
    private final static QName _AddexpertnumResponse_QNAME = new QName("http://service.mw/", "addexpertnumResponse");
    private final static QName _SubexpertnumResponse_QNAME = new QName("http://service.mw/", "subexpertnumResponse");
    private final static QName _Addexpertnum_QNAME = new QName("http://service.mw/", "addexpertnum");
    private final static QName _Reservation_QNAME = new QName("http://service.mw/", "reservation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mw.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Cancel }
     * 
     */
    public Cancel createCancel() {
        return new Cancel();
    }

    /**
     * Create an instance of {@link CancelResponse }
     * 
     */
    public CancelResponse createCancelResponse() {
        return new CancelResponse();
    }

    /**
     * Create an instance of {@link ReservationResponse }
     * 
     */
    public ReservationResponse createReservationResponse() {
        return new ReservationResponse();
    }

    /**
     * Create an instance of {@link Subexpertnum }
     * 
     */
    public Subexpertnum createSubexpertnum() {
        return new Subexpertnum();
    }

    /**
     * Create an instance of {@link HasexportnumberResponse }
     * 
     */
    public HasexportnumberResponse createHasexportnumberResponse() {
        return new HasexportnumberResponse();
    }

    /**
     * Create an instance of {@link Hasexportnumber }
     * 
     */
    public Hasexportnumber createHasexportnumber() {
        return new Hasexportnumber();
    }

    /**
     * Create an instance of {@link Addexpertnum }
     * 
     */
    public Addexpertnum createAddexpertnum() {
        return new Addexpertnum();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link SubexpertnumResponse }
     * 
     */
    public SubexpertnumResponse createSubexpertnumResponse() {
        return new SubexpertnumResponse();
    }

    /**
     * Create an instance of {@link AddexpertnumResponse }
     * 
     */
    public AddexpertnumResponse createAddexpertnumResponse() {
        return new AddexpertnumResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hasexportnumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mw/", name = "hasexportnumber")
    public JAXBElement<Hasexportnumber> createHasexportnumber(Hasexportnumber value) {
        return new JAXBElement<Hasexportnumber>(_Hasexportnumber_QNAME, Hasexportnumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasexportnumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mw/", name = "hasexportnumberResponse")
    public JAXBElement<HasexportnumberResponse> createHasexportnumberResponse(HasexportnumberResponse value) {
        return new JAXBElement<HasexportnumberResponse>(_HasexportnumberResponse_QNAME, HasexportnumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cancel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mw/", name = "cancel")
    public JAXBElement<Cancel> createCancel(Cancel value) {
        return new JAXBElement<Cancel>(_Cancel_QNAME, Cancel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mw/", name = "cancelResponse")
    public JAXBElement<CancelResponse> createCancelResponse(CancelResponse value) {
        return new JAXBElement<CancelResponse>(_CancelResponse_QNAME, CancelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mw/", name = "reservationResponse")
    public JAXBElement<ReservationResponse> createReservationResponse(ReservationResponse value) {
        return new JAXBElement<ReservationResponse>(_ReservationResponse_QNAME, ReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subexpertnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mw/", name = "subexpertnum")
    public JAXBElement<Subexpertnum> createSubexpertnum(Subexpertnum value) {
        return new JAXBElement<Subexpertnum>(_Subexpertnum_QNAME, Subexpertnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddexpertnumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mw/", name = "addexpertnumResponse")
    public JAXBElement<AddexpertnumResponse> createAddexpertnumResponse(AddexpertnumResponse value) {
        return new JAXBElement<AddexpertnumResponse>(_AddexpertnumResponse_QNAME, AddexpertnumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubexpertnumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mw/", name = "subexpertnumResponse")
    public JAXBElement<SubexpertnumResponse> createSubexpertnumResponse(SubexpertnumResponse value) {
        return new JAXBElement<SubexpertnumResponse>(_SubexpertnumResponse_QNAME, SubexpertnumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addexpertnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mw/", name = "addexpertnum")
    public JAXBElement<Addexpertnum> createAddexpertnum(Addexpertnum value) {
        return new JAXBElement<Addexpertnum>(_Addexpertnum_QNAME, Addexpertnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mw/", name = "reservation")
    public JAXBElement<Reservation> createReservation(Reservation value) {
        return new JAXBElement<Reservation>(_Reservation_QNAME, Reservation.class, null, value);
    }

}
