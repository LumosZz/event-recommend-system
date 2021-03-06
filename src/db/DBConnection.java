package db;

import java.util.List;
import java.util.Set;
import entity.Item;

public interface DBConnection {
	/**
	 * Close the connection
	 */
	public void close();
	
	/**
	 * Insert the favourite items for a user
	 * @param userId
	 * @param itemIds
	 */
	public void setFavoriteItems(String userId, List<String> itemIds);
	
	/**
	 * Delete the favourite items for a user
	 * 
	 * @param userId
	 * @param itemIds
	 */
	public void unsetFavoriteItems(String userId, List<String> itemIds);
	
	/**
	 * Get the favourite items for a user
	 * 
	 * @param userId
	 * @return Set of items
	 */
	public Set<Item> getFavoriteItems(String userId);
	
	/**
	 * Get the favourite item id for a user.
	 * 
	 * @param userId
	 * @return itemIds
	 */
	public Set<String> getFavoriteItemIds(String userId);

	/**
	 * Get categories based on item id
	 * 
	 * @param itemId
	 * @return Set of categories
	 */
	public Set<String> getCategories(String itemId);
	
	/**
	 * Search items near a geo-location and a term (optional)
	 * 
	 * @param userId (X)
	 * @param lat
	 * @param lon
	 * @param term (Nullable)
	 * @return List of items
	 */
	public List<Item> searchItems(double lat, double lon, String term);
	
	/**
	 * Save item into DB
	 * 
	 * @param item
	 */
	public void saveItem(Item item);
	
	/**
	 * Get full name of a user.
	 * 
	 * @param userId
	 * @return String of the full name
	 */
	public String getFullname(String userId);
	
	/**
	 * Return whether the credential is correct
	 * 
	 * @param userId
	 * @param password
	 * @return boolean
	 */
	public boolean verifyLogin(String userId, String password);
	
}
