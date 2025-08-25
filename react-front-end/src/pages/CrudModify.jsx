import React, { useState } from "react";

export default function CrudModify() {
    const [activeTab, setActiveTab] = useState("User");

    // Mock form data for each entity
    const [formData, setFormData] = useState({
        User: { userId: "", firstName: "", lastName: "", phoneNumber: "", email: "", password: "" },
        University: { universityId: "", universityName: "", location: "", domain: "" },
        Tutor: { tutorID: "", hourlyRate: "", bio: "", averageRating: "", verificationStatus: "" },
        Subject: { subjectCode: "", subjectName: "", subjectDescription: "", department: "", difficultyLevel: "" },
        Student: { studentID: "", studentNumber: "", studentCourse: "", yearOfStudy: "" },
        Session: { sessionId: "", startTime: "", endTime: "", location: "", mode: "", cost: "", status: "", notes: "" },
        Review: { reviewID: "", rating: "", comment: "", dateSubmitted: "" },
        Payment: { paymentID: "", amount: "", paymentDate: "", paymentMethod: "", status: "", transactionID: "" },
        Availability: { availabilityID: "", dayOfWeek: "", startTime: "", endTime: "" },
    });

    const handleChange = (entity, field, value) => {
        setFormData({
            ...formData,
            [entity]: { ...formData[entity], [field]: value },
        });
    };

    const handleSave = (entity) => {
        console.log("Saving new record for:", entity, formData[entity]);
        alert(`New ${entity} saved!`);
    };

    const handleUpdate = (entity) => {
        console.log("Updating record for:", entity, formData[entity]);
        alert(`${entity} updated!`);
    };

    const handleDelete = (entity) => {
        console.log("Deleting record for:", entity, formData[entity]);
        alert(`${entity} deleted!`);
    };

    // Render form fields dynamically
    const renderForm = (entity, fields) => (
        <form className="bg-white p-6 shadow rounded-lg space-y-4">
            {fields.map((field) => (
                <div key={field}>
                    <label className="block mb-2 font-medium">{field}</label>
                    <input
                        type="text"
                        value={formData[entity][field]}
                        onChange={(e) => handleChange(entity, field, e.target.value)}
                        className="w-full border px-3 py-2 rounded"
                    />
                </div>
            ))}

            <div className="flex justify-end space-x-2">
                <button
                    type="button"
                    onClick={() => handleSave(entity)}
                    className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700"
                >
                    Save
                </button>
                <button
                    type="button"
                    onClick={() => handleUpdate(entity)}
                    className="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700"
                >
                    Update
                </button>
                <button
                    type="button"
                    onClick={() => handleDelete(entity)}
                    className="bg-red-600 text-white px-4 py-2 rounded hover:bg-red-700"
                >
                    Delete
                </button>
            </div>
        </form>
    );

    const entities = {
        User: ["userId", "firstName", "lastName", "phoneNumber", "email", "password"],
        University: ["universityId", "universityName", "location", "domain"],
        Tutor: ["tutorID", "hourlyRate", "bio", "averageRating", "verificationStatus"],
        Subject: ["subjectCode", "subjectName", "subjectDescription", "department", "difficultyLevel"],
        Student: ["studentID", "studentNumber", "studentCourse", "yearOfStudy"],
        Session: ["sessionId", "startTime", "endTime", "location", "mode", "cost", "status", "notes"],
        Review: ["reviewID", "rating", "comment", "dateSubmitted"],
        Payment: ["paymentID", "amount", "paymentDate", "paymentMethod", "status", "transactionID"],
        Availability: ["availabilityID", "dayOfWeek", "startTime", "endTime"],
    };

    return (
        <div className="p-6">
            <h2 className="text-3xl font-bold mb-6 text-center">Modify Records</h2>

            {/* Tabs */}
            <div className="flex gap-4 mb-6 flex-wrap">
                {Object.keys(entities).map((entity) => (
                    <button
                        key={entity}
                        onClick={() => setActiveTab(entity)}
                        className={`px-4 py-2 rounded ${
                            activeTab === entity ? "bg-blue-600 text-white" : "bg-gray-200"
                        }`}
                    >
                        {entity}
                    </button>
                ))}
            </div>

            {/* Form for the active tab */}
            {renderForm(activeTab, entities[activeTab])}
        </div>
    );
}