package de.atron.books.tabris.demo.entrypoints;

import static de.atron.books.tabris.demo.ui.Constants.IMAGE_ACTION_SEARCH;
import static de.atron.books.tabris.demo.ui.Constants.IMAGE_ACTION_SETTINGS;
import static de.atron.books.tabris.demo.ui.Constants.IMAGE_ACTION_SHARE;
import static de.atron.books.tabris.demo.ui.Constants.IMAGE_ACTION_THEME;
import static de.atron.books.tabris.demo.ui.Constants.IMAGE_PAGE_ALL_BOOKS;
import static de.atron.books.tabris.demo.ui.Constants.IMAGE_PAGE_FAVORITE_BOOKS;
import static de.atron.books.tabris.demo.ui.Constants.IMAGE_PAGE_POPULAR_BOOKS;

import java.io.InputStream;

import org.eclipse.rap.rwt.application.EntryPoint;
import org.eclipse.rap.rwt.application.EntryPointFactory;

import com.eclipsesource.tabris.ui.ActionConfiguration;
import com.eclipsesource.tabris.ui.PageConfiguration;
import com.eclipsesource.tabris.ui.PlacementPriority;
import com.eclipsesource.tabris.ui.TabrisUIEntryPoint;
import com.eclipsesource.tabris.ui.UIConfiguration;

import de.atron.books.tabris.demo.ui.AllBooksPage;
import de.atron.books.tabris.demo.ui.BookDetailsPage;
import de.atron.books.tabris.demo.ui.BookSearchAction;
import de.atron.books.tabris.demo.ui.ChangeThemeAction;
import de.atron.books.tabris.demo.ui.FavoriteBooksPage;
import de.atron.books.tabris.demo.ui.PopularBooksPage;
import de.atron.books.tabris.demo.ui.ReadBookPage;
import de.atron.books.tabris.demo.ui.SearchResultsPage;
import de.atron.books.tabris.demo.ui.SettingsAction;
import de.atron.books.tabris.demo.ui.SettingsPage;
import de.atron.books.tabris.demo.ui.ShareAction;

public class BooksDemo implements EntryPointFactory {

  @Override
  public EntryPoint create() {
    return new TabrisUIEntryPoint( createConfiguration() );
  }

  private UIConfiguration createConfiguration() {
    UIConfiguration configuration = new UIConfiguration();
    // configuration.setImage( getImage( IMAGE_BOOK_STORE_UI ) );
    createPages( configuration );
    createPageSettings( configuration );
    createGlobalActions( configuration );
    return configuration;
  }

  private void createPages( UIConfiguration configuration ) {
    createAllBooksPage( configuration );
    createPopularBooksPage( configuration );
    createFavoriteBooksPage( configuration );
    createBookDetailsPage( configuration );
    createReadBookPage( configuration );
    createSearchResultsPage( configuration );
  }

  private void createAllBooksPage( UIConfiguration configuration ) {
    PageConfiguration page = new PageConfiguration( AllBooksPage.class.getName(),
                                                    AllBooksPage.class );
    page.setTitle( "All Books" );
    page.setImage( getImage( IMAGE_PAGE_ALL_BOOKS ) );
    page.setTopLevel( true );
    configuration.addPageConfiguration( page );
  }

  private void createPopularBooksPage( UIConfiguration configuration ) {
    PageConfiguration page = new PageConfiguration( PopularBooksPage.class.getName(),
                                                    PopularBooksPage.class );
    page.setTitle( "Popular" );
    page.setImage( getImage( IMAGE_PAGE_POPULAR_BOOKS ) );
    page.setTopLevel( true );
    configuration.addPageConfiguration( page );
  }

  private void createFavoriteBooksPage( UIConfiguration configuration ) {
    PageConfiguration page = new PageConfiguration( FavoriteBooksPage.class.getName(),
                                                    FavoriteBooksPage.class );
    page.setTitle( "Favorite" );
    page.setImage( getImage( IMAGE_PAGE_FAVORITE_BOOKS ) );
    page.setTopLevel( true );
    configuration.addPageConfiguration( page );
  }

  private void createBookDetailsPage( UIConfiguration configuration ) {
    PageConfiguration page = new PageConfiguration( BookDetailsPage.class.getName(),
                                                    BookDetailsPage.class );
    page.setTitle( "Book" );
    ActionConfiguration action = new ActionConfiguration( ShareAction.class.getName(),
                                                          ShareAction.class );
    action.setImage( getImage( IMAGE_ACTION_SHARE ) );
    action.setTitle( "Share" );
    page.addActionConfiguration( action );
    configuration.addPageConfiguration( page );
  }

  private void createReadBookPage( UIConfiguration configuration ) {
    PageConfiguration page = new PageConfiguration( ReadBookPage.class.getName(),
                                                    ReadBookPage.class );
    page.setTitle( "Book" );
    ActionConfiguration action = new ActionConfiguration( ChangeThemeAction.class.getName(),
                                                          ChangeThemeAction.class );
    action.setImage( getImage( IMAGE_ACTION_THEME ) );
    action.setTitle( "Change Theme" );
    page.addActionConfiguration( action );
    configuration.addPageConfiguration( page );
  }

  private void createPageSettings( UIConfiguration configuration ) {
    PageConfiguration page = new PageConfiguration( SettingsPage.class.getName(),
                                                    SettingsPage.class );
    page.setTitle( "Settings" );
    configuration.addPageConfiguration( page );
  }

  private void createSearchResultsPage( UIConfiguration configuration ) {
    PageConfiguration page = new PageConfiguration( SearchResultsPage.class.getName(),
                                                    SearchResultsPage.class );
    configuration.addPageConfiguration( page );
  }

  private void createGlobalActions( UIConfiguration configuration ) {
    ActionConfiguration action = new ActionConfiguration( BookSearchAction.class.getName(),
                                                          BookSearchAction.class );
    action.setImage( getImage( IMAGE_ACTION_SEARCH ) );
    action.setTitle( "Search" );
    action.setPlacementPriority( PlacementPriority.HIGH );
    configuration.addActionConfiguration( action );
    action = new ActionConfiguration( SettingsAction.class.getName(), SettingsAction.class );
    action.setPlacementPriority( PlacementPriority.LOW );
    action.setImage( getImage( IMAGE_ACTION_SETTINGS ) );
    action.setTitle( "Settings" );
    configuration.addActionConfiguration( action );
  }

  private InputStream getImage( String path ) {
    return BooksDemo.class.getResourceAsStream( path );
  }
}