package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import base.GameRuleDAL;
import domain.GameRuleDomainModel;
import util.HibernateUtil;

public class GameRuleBLL {

	public static ArrayList<GameRuleDomainModel> getRules() {

		return GameRuleDAL.getRules();
	}
	
	public static HashMap<String, GameRuleDomainModel> getRuleHashSet() {
		HashMap<String, GameRuleDomainModel> HashRuleSet = new HashMap();
		
		for(GameRuleDomainModel gr: GameRuleDAL.getRules()) {
			HashRuleSet.put(gr.getRULENAME(), gr);
		}
		
		return HashRuleSet;
	}

	
}
