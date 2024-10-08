package vip.hoode.object.type;

public interface JsonViewGroups {

    interface Default {
    }

    interface EntityCombination extends IdentityField, CreateTimeField, UpdateTimeField {

    }

    interface IdentityField extends Default {
    }

    interface CreateTimeField extends Default {
    }

    interface UpdateTimeField extends Default {
    }

    interface UserField extends Default {

    }


}
