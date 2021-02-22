package fr.eni.encheres.bll;

import java.util.Date;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;

import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EncheresDAO;


public class EncheresManager {

	
		private static final String INSTANCE = null;//
		// Doit disposer d'un accès à la DAL en passant par le DAOFactory => Création de
		// la DAOFactory dans DAL
		private EncheresDAO daoEncheres;
		
		public EncheresManager() {
			daoEncheres = DAOFactory.getEncheresDAO();
		
			
		}
	

		public Enchere retournerEnchere(int no_enchere) throws BusinessException {
			return daoEncheres.selectByNoEnchere(no_enchere);
		}
	
		public List<Enchere> ListeEncheres() throws BusinessException {
			return daoEncheres.selectAll();
		}
		
		
		public Enchere ajoutEnchere (int no_enchere, Date date_enchere, int montant_enchere, int no_article, int no_utilisateur) throws BusinessException {

		
			Enchere enchere = new Enchere();
			enchere.setNoEncheres(no_enchere);
			enchere.setDateEnchere((java.sql.Date) date_enchere);
			enchere.setMontant_enchere(montant_enchere);
			enchere.setNoArticle(no_article);
			enchere.setNoUtilisateur(no_utilisateur);

			this.daoEncheres.ajoutEnchere(enchere);

			return enchere;
		}
		
		
		public void supprimerEnchere(int no_enchere) throws BusinessException {
			this.daoEncheres.supprimerEnchere(no_enchere);
}
		
		
		public void modifierEnchere (Enchere enchere) throws BusinessException {
			
			
			this.daoEncheres.modifierEnchere(enchere);
		}

}