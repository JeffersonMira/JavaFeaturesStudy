#Documentation for spring - https://angular.io/

# MyFirstApp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.2.0.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).
Before running the tests make sure you are serving the app via `ng serve`.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

##%% Comment about ANGULAR 2%%##

NG ->
NPM -> Node P? M? 
CLI -> https://github.com/angular/angular-cli/wiki
TypeScript :  the same as JS but with more features, like classes, interfaces, types (strong). IT is compiled to JS (as it runs in the server) using CLI
databindding = communication between the typeScript code (business logic) and the template (HTML)
String interpolation {{data }}
property binding [property] = "data"
Directives are Instructions in the DOM

#comandos#
ng new my-project
cd my-project
ng serve : run the application
ng generate component <name> (or ng g c <name>) : criar component usando comandos 

npm install -g @angular/cli -> começar projeto

# Including bootstrap #
npm install --save bootstrap
After doing it, you should go to .angular-cli.json and add the following line at styles: "../node_modules/bootstrap/dist/css/bootstrap.min.css",
Then it is necessary to restart the application.

#watch again#
2.13 how an angular app gets loaded and started

#Debugging#
download augury extension for chrome. it will help on debbuging


@Input faz com que a variável seja acessível de outros components.
Também é necessário  fazer um 'cast' no outro component, usando o [] (i.e [element])


bind events you have to create an object and define it as an EventEmitter. Also needs to mark it as @Output
@Output 
ViewEncapsulation : Modo que o Angular trabalha para que as configurações aplicadas em um módulo não influenciem em outros módulos indesejados.


attribute directives 
look like a normal HTML attribute (possible with databinding or event binding)
only affect/change the element thry are added to
[ngClass] [ngStyle]

Structural Directives
Look like a normal HTML attribute but have a leading * 
affect a whole area of DOM (elements get added/removed)
cant have more than one in the same element


#Services and dependency injections

# To learn more about observables on Angular - http://reactivex.io/rxjs


#Forms
there are two diferent approachs:
  1) Template Driven - Angular infers the Form Object from the DOM.
  2) Reactive - Form is created programmatically and synchronized with DOM.
  
#Which Validators do ship with Angular? 
  Check out the Validators class: https://angular.io/docs/ts/latest/api/forms/index/Validators-class.html - these are all built-in validators, though that are the methods which actually get executed (and which you later can add when using the reactive approach).
  For the template-driven approach, you need the directives. You can find out their names, by searching for "validator" in the official docs: https://angular.io/api?type=directive - everything marked with "D" is a directive and can be added to your template.
  Additionally, you might also want to enable HTML5 validation (by default, Angular disables it). You can do so by adding the ngNativeValidate  to a control in your template.


#FIREBASE - NEED TO CHECK!! VIDEO 233
https://ng-recipe-book-d4b97.firebaseio.com/ -> this is the project used for this course.


More about JWT
Section 20, Lecture 249
Want to learn about the Token which is exchanged? 

The following page should be helpful: https://jwt.io/ - specifically, the introduction: https://jwt.io/introduction/
npm install --save firebase

=> Note the token that is returned by the authService is stores in the Local Storage from the firebase.
  
#Protecting Lazy Loaded Routes with canLoad
  What if you want to use route protection (canActivate  to be precise) on lazily loaded routes?
  You can add canActivate to the lazy loaded routes but that of course means, that you might load code which in the end can't get accessed anyways. It would be better to check that BEFORE loading the code.
  You can enforce this behavior by adding the canLoad  guard to the route which points to the lazily loaded module:
  { path: 'recipes', loadChildren: './recipes/recipes.module#RecipesModule', canLoad: [AuthGuard] } 
  In this example, the AuthGuard  should implement the CanLoad interface.


#Ahead of time compilation
The compilation of angular to java is done by CLI. But angular compiles my templates into HTML and JS. There are two tipes of it:
1) Just in Time compilations - Developmento -> production -> App gets downloaded in Browser -> Parsing and compiling to JS
2) Ahead of Time compilations - Development -> Parsing and Compiling to JS-> Prodution -> App gets downloaded in Browser
ng build --prod --aot (ahead of time compilation)


#Deploying - AWS (Amazon Web Services) - Free approach
Amazon Web Service S3 free tear
ng build --prod --aot
select all the files in DIST folder


#Redux approach - NgRx 
 to install : npm install --save @ngrx/store
 Needs to study this thing.. not really idea how to implment it.
 There is even a chrome plugin that I can install.
 
Official Github Repo with Documentation: https://github.com/ngrx/platform
Angular & NgRx Tutorial: https://blog.nrwl.io/using-ngrx-4-to-manage-state-in-angular-applications-64e7a1f84b7b
NgRx Patterns & Techniques: https://blog.nrwl.io/ngrx-patterns-and-techniques-f46126e2b1e5


#Angular testing.
Official Docs: https://angular.io/docs/ts/latest/guide/testing.html
I can also recommend the following Article: https://semaphoreci.com/community/tutorials/testing-components-in-angular-2-with-jasmine
