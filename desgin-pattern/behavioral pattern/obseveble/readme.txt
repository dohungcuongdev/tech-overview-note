The observer pattern is a software design pattern 
in which an object, called the subject, maintains a list of its dependents, called observers, 
and notifies them automatically of any state changes, usually by calling one of their methods.

More details:
Subject maintains list observers
new observer can be registered into list observers
registered observers can be unregistered
any state changes, subject will automatically notify to the registered observers, unregistered observers won't be notified