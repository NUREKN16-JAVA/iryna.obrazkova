package ua.nure.obrazkova.iryna.usermanagement.db;

import ua.nure.obrazkova.iryna.usermanagement.User;

import java.util.Collection;

public interface UserDao {

    /**
     * Sets connection factory.
     *
     */
    void setConnectionFactory(ConnectionFactory connectionFactory);

    /**
     * Add new user to the database.
     *
     * @param user with null id
     * @return user with autogenerated id
     */
    User create(final User user) throws DatabaseException;

    /**
     * Finds a user in database with matching id.
     *
     * @return user with specified id
     * @throws DatabaseException if user not found or there are more
     * than one user with specified id
     */
    User find(final Long id) throws DatabaseException;

    /**
     * Finds a user with specified first name and last name.
     *
     * @return user collection
     */
    Collection<User> find(final String firstName, final String lastName) throws DatabaseException;

    /**
     * Finds all users in database.
     *
     * @return users collection
     */
    Collection<User> findAll() throws DatabaseException;

    /**
     * Updates user's record in the database with provided User object.
     */
    void update(final User user) throws DatabaseException;


    /**
     * Deletes user's record from the database
     * that's matching provided User object id field.
     */
    void delete(final Long id) throws DatabaseException;
}
