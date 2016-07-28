package de.atron.books.tabris.demo;

import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;

import com.eclipsesource.tabris.TabrisClientInstaller;

import de.atron.books.tabris.demo.entrypoints.BooksDemo;

public class Configuration implements ApplicationConfiguration {

  public void configure( Application application ) {
    bootstrapTabris( application );
    application.addEntryPoint( "/ui", new BooksDemo(), null );
  }

  private void bootstrapTabris( Application application ) {
    TabrisClientInstaller.install( application );
  }
}
