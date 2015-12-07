package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import base.GameRuleCardsDAL;
import base.GameRuleDAL;
import domain.GameRuleCardsDomainModel;
import domain.GameRuleDomainModel;
import util.HibernateUtil;

public class GameRuleCardsBLL   {

	public static ArrayList<GameRuleCardsDomainModel> getCardsRules(int ruleID) {
		
		ArrayList<GameRuleCardsDomainModel> grC = new ArrayList<GameRuleCardsDomainModel>();
		for(GameRuleCardsDomainModel grCards : GameRuleCardsDAL.getRules()){
			if (grCards.getRULEID() == ruleID) {
				grC.add(grCards);
			}
		}
		return grC;
	}

	public static HashMap<String, GameRuleCardsDomainModel> getRuleHashSet(int ruleID) {
		HashMap<String, GameRuleCardsDomainModel> HashRuleCardsSet = new HashMap();

		for (GameRuleCardsDomainModel gr : getCardsRules(ruleID)) {
			String keyVal = "" + gr.getRULECARDID();
			HashRuleCardsSet.put(keyVal, gr);
		}

		return HashRuleCardsSet;
	}
	
}
