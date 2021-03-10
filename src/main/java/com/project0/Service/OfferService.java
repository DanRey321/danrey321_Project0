package com.project0.Service;

import com.project0.Dao.FinanceDOA;
import com.project0.Dao.UserDOA;
import com.project0.Util.DansArrayList;
import com.project0.model.Cars;
import com.project0.model.Offers;
import com.project0.model.Payments;

public class OfferService {
    private FinanceDOA financeDOA;
    private UserDOA userDOA;

    public OfferService() {
        this.financeDOA = new FinanceDOA();
    }

    public OfferService(FinanceDOA financeDOA, UserDOA userDOA) {
        this.financeDOA = financeDOA;
        this.userDOA = userDOA;
    }

    public DansArrayList<Offers> getAllOffers(){

        return financeDOA.ViewOffers();

    }

    public Offers makeOffer(int userID, int carID, double offer){
        return financeDOA.makeOfferDOA(userID,carID,offer);
    }

    public Offers declineOffer(int offerID){
        return financeDOA.declineOffer(offerID);
    }

    public Cars updateOwnerService(int ownerID, int carID){
        return financeDOA.updateOwner(ownerID, carID);
    }

    public Offers updateOfferStatus(int offerID){
        return financeDOA.updateOfferStatus2(offerID);
    }

    public Offers deleteOffers(int carID){
        return financeDOA.deleteRemainingOffers(carID);
    }

    public Offers getOffer(int offerID){
        return financeDOA.getOffer(offerID);
    }

    public Payments createPlanService(int ownerID, int carID, double balance){
        return financeDOA.createPlan(ownerID, carID, balance);
    }

}
